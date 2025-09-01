package com.Learner.hospitalManagement.config;

import com.Learner.hospitalManagement.entity.User;
import graphql.schema.DataFetcher;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

    @Bean
    public RuntimeWiring buildingWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("getUserById", getUserByIdFetcher())
                )
                .build();

    }

    private DataFetcher<User> getUserByIdFetcher() {
        return dataFetchEnvironment -> {
            String id = dataFetchEnvironment.getArgument("id");
            return new User("Shyam23", "112233");
        };
    }
}
