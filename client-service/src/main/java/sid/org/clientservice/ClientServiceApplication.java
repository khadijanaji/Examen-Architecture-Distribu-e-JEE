package sid.org.clientservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sid.org.clientservice.Entity.Client;
import sid.org.clientservice.Repositorys.ClientRepostorys;

@SpringBootApplication
public class ClientServiceApplication {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepostorys c){
        repositoryRestConfiguration.exposeIdsFor(Client.class);
        return args -> {
            Client cl=new Client(null,"123456","Glsid","glsid@glsid.com");
            Client cl2=new Client(null,"132456789","Glsid1","tes@gmail.com");
            c.save(cl);
            c.save(cl2);
        };
    }
}
