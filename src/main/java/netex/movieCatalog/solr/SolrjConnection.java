package netex.movieCatalog.solr;

import com.querydsl.jpa.impl.JPAQueryFactory;
import netex.movieCatalog.model.Movie;
import netex.movieCatalog.model.QMovie;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SolrjConnection {
    private static final String solrUrl = "http://localhost:8983/solr/MovieCatalogSolrj";
    private static final SolrClient solr = getSolrClient();

    private static SolrClient getSolrClient() {
        return new HttpSolrClient.Builder(solrUrl).withConnectionTimeout(10000).withSocketTimeout(5000).build();
    }

    public void indexingByUsingJavaObjectBinding() {
        try {
            List<Movie> movies = getQueryFactory().selectFrom(QMovie.movie).fetch();
            System.out.printf("Indexing %d movie...\n", movies.size());

            solr.addBeans(movies);

            solr.commit();

            System.out.printf("%d articles indexed.\n", movies.size());

        } catch (SolrServerException | IOException e) {
            System.err.printf("\nFailed to indexing articles: %s", e.getMessage());
        }
    }

    private JPAQueryFactory getQueryFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("moviestabel");
        EntityManager em = emf.createEntityManager();
        return new JPAQueryFactory(em);
    }

    public void queryingByUsingSolrParams() {
        final Map<String, String> queryParamMap = new HashMap();
        queryParamMap.put("q", "title:War");
        queryParamMap.put("sort", "id asc");
        MapSolrParams queryParams = new MapSolrParams(queryParamMap);

        QueryResponse response = null;
        try {
            response = solr.query(queryParams);
        } catch (SolrServerException | IOException e) {
            System.err.printf("Failed to search articles: %s", e.getMessage());
        }

        if (response != null) {
            System.out.println(response.getResults());
        }
    }
}
