package netex.movieCatalog;

import netex.movieCatalog.solr.SolrjConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);

        SolrjConnection solrjConnection = new SolrjConnection();
        solrjConnection.indexingByUsingJavaObjectBinding();
        solrjConnection.queryingByUsingSolrParams();
    }
}