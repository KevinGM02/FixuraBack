package com.Fixura.FixuraBackEnd.Repository;
import java.util.List;
import com.Fixura.FixuraBackEnd.Model.Incidente;
public interface IincidenteRepository {
    public List<Incidente> Listar_incidente_usuario(String dni);
    public List<Incidente> Listar_incidente_Municipalidad(String distrito);
	public int save(Incidente incidente);
	public int update_estado(Incidente incidente);
    public int update_categoria(Incidente incidente);
	public int delete(int id);
}
