package br.com.ovort.remote.client.viacep;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import static br.com.ovort.remote.RemoteConstants.CB_RETRY_FIND_CEP_BY_ID;

@FeignClient(url = "${viacep.url}", name = "viacep")
public interface ViaCepClient {

    @GetMapping("${viacep.endpoint.get-by-cep}")
    @Retry(name = CB_RETRY_FIND_CEP_BY_ID)
    @CircuitBreaker(name = CB_RETRY_FIND_CEP_BY_ID)
    Optional<ViaCepResponse> findCepById(@PathVariable(name = "cep") String cep);

}
