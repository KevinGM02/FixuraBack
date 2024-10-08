package com.Fixura.FixuraBackEnd.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Fixura.FixuraBackEnd.Model.Incidente;

@Repository
public class IncidenteRepository implements IincidenteRepository{
    @Autowired
	private JdbcTemplate jdbcTemplate;
    @Override
	public List<Incidente> Listar_incidente_usuario(String dni) {
		String sql = "select * from Incidencia where DNI='"+dni+"'";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Incidente.class));
	}
    @Override
	public List<Incidente> Listar_incidente_Municipalidad(String distrito) {
		String sql = "select * from Incidencia inner join Usuarios on Incidencia.DNI=Usuarios.DNI where Usuarios.id_distrito='"+distrito+"' ";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Incidente.class));
	}
	@Override
	public int save(Incidente incidente) {
		String sql = "INSERT INTO Incidencia(fecha_publicacion,descripcion,ubicacion,imagen,total_votos,id_estado,DNI,id_categoria) VALUES(?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,new Object[] {incidente.getFecha_publicacion(),incidente.getDescripcion(),incidente.getUbicacion(),incidente.getImagen(),incidente.getTotal_votos(),
            incidente.getId_estado(),incidente.getDNI(),incidente.getId_categoria()});
	}

	@Override
	public int update_estado(Incidente incidente) {
		String sql = "UPDATE Incidencia SET id_estado=? WHERE id_incidencia=?";
		return jdbcTemplate.update(sql,new Object[] {incidente.getId_estado(),incidente.getId_incidencia()});
	}
    @Override
	public int update_categoria(Incidente incidente) {
		String sql = "UPDATE Incidencia SET id_categoria=? WHERE id_incidencia=?";
		return jdbcTemplate.update(sql,new Object[] {incidente.getId_categoria(),incidente.getId_incidencia()});
	}
	@Override
	public int delete(int id) {
		String sql = "DELETE Incidencia where id_incidencia=?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}

}
