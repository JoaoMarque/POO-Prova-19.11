package com.ha.padaria.Service;

import com.ha.padaria.Model.PadariaModel;
import com.ha.padaria.Repository.PadariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PadariaService {

    private final PadariaRepository padariaRepository;

    public PadariaService(PadariaRepository padariaRepository) {
        this.padariaRepository = padariaRepository;
    }

    public List<PadariaModel> findAll() {
        return padariaRepository.findAll();
    }

    public PadariaModel buscarPorId(Long id) {
        return padariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Padaria não encontrada"));
    }

    public PadariaModel criarPadaria(PadariaModel padariaModel) {
        return padariaRepository.save(padariaModel);
    }

    public PadariaModel atualizarPadaria(Long id, PadariaModel padariaModel) {
        PadariaModel padaria = buscarPorId(id);
        padaria.setNome(padariaModel.getNome());
        padaria.setEndereco(padariaModel.getEndereco());
        return padariaRepository.save(padaria);
    }

    public void deletarPadaria(Long id) {
        buscarPorId(id);
        padariaRepository.deleteById(id);
    }
}