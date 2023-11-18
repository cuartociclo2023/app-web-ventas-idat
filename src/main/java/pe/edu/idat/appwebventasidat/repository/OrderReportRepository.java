package pe.edu.idat.appwebventasidat.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.idat.appwebventasidat.model.bd.sp.OrderReport;

import java.util.List;

@Repository
public interface OrderReportRepository extends
        JpaRepository<OrderReport, Integer> {

    @Query(value = "{call sp_reporte(:filtro)}", nativeQuery = true)
    List<OrderReport> listarOrdenes(@Param("filtro") String filtro);

    @Transactional
    @Modifying
    @Query(value = "{call sp_registrar_reporte(:dato, :fecha, :valor)}"
    ,nativeQuery = true)
    void registraReporte(@Param("dato") String dato,
                         @Param("fecha") String fecha,
                         @Param("valor") String valor);

}
