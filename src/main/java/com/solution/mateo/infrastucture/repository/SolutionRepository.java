package com.solution.mateo.infrastucture.repository;

import com.solution.mateo.domain.cun.SolutionCun;
import com.solution.mateo.infrastucture.entity.FoodEntity;
import com.solution.mateo.infrastucture.entity.SolutionEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Mono;

public interface SolutionRepository extends ReactiveMongoRepository<SolutionEntity,String> {

    @Aggregation(pipeline={

           " { '$lookup': { "+
               " 'from': 'plague',  "+
               " 'localField': 'idPlague' "+
               " 'foreignField': 'idPlague', " +
               " 'as': 'solutionCun' }  } ",
            //"{' $match':{'nombre':?0, 'name': {$gt: ?1} }}",
            "{ '$match' : { 'idRegion': ?0} }",
           " { '$project': { " +
             //      "'_id': 0, " +
             "'_id': 1, " +
             "'idPlague': 1, " +
             "'sugerencia': '$sugerencia', " +
             "'nombre': 'plague.nombre', " +
             "'periodoAplicacion': 1, " +
             "'tiempoAplicacion': 1 } } "

    })
    Mono<SolutionCun> findSolution( @Param("name") String name);
}
