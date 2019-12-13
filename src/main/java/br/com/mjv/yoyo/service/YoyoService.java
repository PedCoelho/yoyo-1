package br.com.mjv.yoyo.service;

import br.com.mjv.yoyo.model.Yoyo;
import br.com.mjv.yoyo.repository.YoyoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YoyoService {

    @Autowired
    private YoyoRepository yoyoRepository;

    public Yoyo add(Yoyo yoyo){
        return yoyoRepository.save(yoyo);
    }

    public List<Yoyo> findAll(){
        return yoyoRepository.findAll();
    }

    public Yoyo findById(Integer id) throws NotFoundException {
        Optional<Yoyo> optYoyo = yoyoRepository.findById(id);

        if(optYoyo.isPresent()){
            return optYoyo.get();
        }
        throw new NotFoundException("");
    }
}
