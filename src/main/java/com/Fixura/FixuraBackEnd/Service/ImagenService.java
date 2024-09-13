package com.Fixura.FixuraBackEnd.Service;
import com.Fixura.FixuraBackEnd.Model.Imagen;
import com.Fixura.FixuraBackEnd.Repository.ImagenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImagenService implements IimagenService{
    @Autowired
	private ImagenRepository imagenRepository;
    @Override
	public int save(Imagen imagen) {
		int exitosamente;
		try {
			exitosamente=imagenRepository.save(imagen);
		}catch (Exception ex) {
			throw ex;
		}
		return exitosamente;
	}
}
