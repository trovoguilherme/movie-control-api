package br.com.ovort.service;

import br.com.ovort.entity.filme.Filme;
import br.com.ovort.repository.FilmeGeneroRepository;
import br.com.ovort.repository.FilmeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FilmeServiceTest {

    @InjectMocks
    private FilmeService filmeService;

    @Mock
    private FilmeRepository filmeRepository;

    @Mock
    private FilmeGeneroRepository filmeGeneroRepository;

    @Mock
    private MovieService movieService;

    @Captor
    private ArgumentCaptor<Filme> captor;

    @Test
    @DisplayName("Deve atualizar nota e comentário do Filme")
    void shouldUpadateNotaAndComentarioFilme() {
        //Expected
        final Double NOTA = 11.0;
        final String COMENTARIO = "Melhor filme";

        var filme = buildFilme();

        when(filmeRepository.findById(anyInt())).thenReturn(Optional.of(filme));

        filmeService.patchNotaOrComentario(1, NOTA, COMENTARIO);
        verify(filmeRepository).save(captor.capture());

        assertEquals(NOTA, captor.getValue().getNota());
        assertEquals(COMENTARIO, captor.getValue().getComentario());
    }

    private Filme buildFilme() {
        return Filme.builder()
                .id(1)
                .titulo("Ilha do Medo")
                .tituloOriginal("Shutter Island")
                .sinopse("Na década de 50, a fuga de uma assassina leva o detetive Teddy Daniels e seu parceiro a investigarem o seu desaparecimento de um quarto trancado em um hospital psiquiátrico. Lá, uma rebelião se inicia e o agente terá que enfrentar seus próprios medos.")
                .dataLancamento(LocalDateTime.parse("2010-02-14" + "T00:00:00"))
                .tempo(138)
                .budget(80000000)
                .nota(10.0)
                .comentario("Bom demais")
                .dataCriacao(LocalDateTime.now())
                .build();
    }

}
