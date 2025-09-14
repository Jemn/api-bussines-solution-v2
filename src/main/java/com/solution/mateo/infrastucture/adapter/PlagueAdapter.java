package com.solution.mateo.infrastucture.adapter;


import com.solution.mateo.application.mapper.PlagueMapper;
import com.solution.mateo.application.util.Constantes;
import com.solution.mateo.domain.dto.CreatePlagueRequestDTO;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Plague;
import com.solution.mateo.domain.port.out.PlagueOutputPort;
import com.solution.mateo.infrastucture.repository.PlagueRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
@Log
public class PlagueAdapter implements PlagueOutputPort {

    private final PlagueRepository plagueRepository;

    @Override
    public Mono<BodyResponse<Object>> findById(String id, String idTxt) {
        return plagueRepository.findById(id).map(PlagueMapper.INSTANCE::toDto).map(x -> BodyResponse.builder().codRespuesta(Constantes.NUM_CERO).mensajeRespuesta(Constantes.MENSAJE_OK).idtransasacion(idTxt).data(x).build()).switchIfEmpty(Mono.just(BodyResponse.builder().codRespuesta(Constantes.NUM_UNO).mensajeRespuesta(Constantes.MENSAJE_ID_NOEXISTE).idtransasacion(idTxt).build())).onErrorReturn(BodyResponse.builder().codRespuesta(Constantes.NUM_UNO).mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO).idtransasacion(idTxt).build());
    }

    @Override
    public Mono<BodyResponse<Object>> save(Plague plague, String idTxt) {
        return plagueRepository.save(PlagueMapper.INSTANCE.toEntity(plague)).map(PlagueMapper.INSTANCE::toDto).map(x -> BodyResponse.builder().codRespuesta(Constantes.NUM_CERO).mensajeRespuesta(Constantes.MENSAJE_OK).idtransasacion(idTxt).data(x).build()).switchIfEmpty(Mono.just(BodyResponse.builder().codRespuesta(Constantes.NUM_UNO).mensajeRespuesta(Constantes.MENSAJE_ID_NOEXISTE).idtransasacion(idTxt).build())).onErrorReturn(BodyResponse.builder().codRespuesta(Constantes.NUM_UNO).mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO).idtransasacion(idTxt).build());
    }

    @Override
    public Mono<BodyResponse<Object>> update(CreatePlagueRequestDTO plague, String idTxt) {
        return plagueRepository.findById(plague.getId()).flatMap(y -> {
            y.setTipo(plague.getTipo());
            y.setNombre(plague.getNombre());
            y.setFlagEli(plague.getFlagEli());
            y.setNombreCientifico(plague.getNombreCientifico());
            y.setCausa(plague.getCausa());
            y.setFoto(plague.getFoto());
            y.setFechaUpdate(plague.getFechaUpdate());
            y.setUsuarioUpdate(plague.getUsuarioUpdate());
            return plagueRepository.save(y).map(PlagueMapper.INSTANCE::toDto);
        }).map(x -> BodyResponse.builder().codRespuesta(Constantes.NUM_CERO).mensajeRespuesta(Constantes.MENSAJE_OK).idtransasacion(idTxt).data(x).build()).switchIfEmpty(Mono.just(BodyResponse.builder().codRespuesta(Constantes.NUM_UNO).mensajeRespuesta(Constantes.MENSAJE_ID_NOEXISTE).idtransasacion(idTxt).build())).onErrorResume(e -> {
            log.info("error al procesar :" + e.getMessage());
            log.info("error al procesar :" + e.getStackTrace());
            return Mono.just(BodyResponse.builder().codRespuesta(Constantes.NUM_UNO).mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO).idtransasacion(idTxt).build());
        });
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return plagueRepository.deleteById(id);
    }

    @Override
    public Flux<Plague> findAll(Pageable pageable) {
        Sort sort = pageable.getSort();
        return plagueRepository.findAll(sort).map(PlagueMapper.INSTANCE::toDto).skip(pageable.getOffset()) // Salta los elementos de las páginas anteriores
                .take(pageable.getPageSize());
    }

    /*
        @Override
    public Flux<Plague> findAll() {
        return plagueRepository.findAll().map(PlagueMapper.INSTANCE::toDto);
    }
     */
}
