/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.controller;

/**
 *
 * @author JesusArmando
 */
import com.ibm.dao.AsesorDAO;
import com.ibm.dao.ClienteConTarjetaDAO;
import com.ibm.dao.ClienteDAO;
import com.ibm.dao.ConsumoDAO;
import com.ibm.dao.HistorialConsumoDAO;
import com.ibm.dao.TarjetaDAO;
import com.ibm.dto.AsesorDTO;
import com.ibm.dto.ClienteConTarjetaDTO;
import com.ibm.dto.ClienteDTO;
import com.ibm.dto.ConsumoDTO;
import com.ibm.dto.HistorialConsumoDTO;
import com.ibm.dto.TarjetaDTO;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ibm")
public class Controller {

    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public ClienteDTO agregarCliente(@RequestBody ClienteDTO cliente) {
        ClienteDAO ad = new ClienteDAO();
        ad.agregar(cliente);
        return cliente;
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<ClienteDTO> buscarClientes() {
        ClienteDAO ad = new ClienteDAO();
        return ad.buscarTodos();
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
    public ClienteDTO buscarCliente(@PathVariable("id") Integer id) {
        ClienteDAO ad = new ClienteDAO();
        return ad.buscar(id);
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.PUT)
    public ClienteDTO actualizarCliente(@RequestBody ClienteDTO cliente) {
        ClienteDAO ad = new ClienteDAO();
        return ad.actualizar(cliente);
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
    public ClienteDTO eliminarCliente(@PathVariable("id") Integer id) {
        ClienteDAO ad = new ClienteDAO();
        return ad.eliminar(id);
    }

    @RequestMapping(value = "/consumo/{id}", method = RequestMethod.DELETE)
    public ConsumoDTO eliminarConsumo(@PathVariable("id") Integer id) {
        ConsumoDAO ad = new ConsumoDAO();
        return ad.eliminar(id);
    }

    @RequestMapping(value = "/consumo", method = RequestMethod.POST)
    public ConsumoDTO agregarConsumo(@RequestBody ConsumoDTO consumo) {
        ConsumoDAO ad = new ConsumoDAO();
        ad.agregar(consumo);
        return consumo;
    }

    @RequestMapping(value = "/consumo", method = RequestMethod.GET)
    public List<ConsumoDTO> buscarConsumos() {
        ConsumoDAO ad = new ConsumoDAO();
        return ad.buscarTodos();
    }

    @RequestMapping(value = "/consumo/{id}", method = RequestMethod.GET)
    public ConsumoDTO buscarConsumo(@PathVariable("id") Integer id) {
        ConsumoDAO ad = new ConsumoDAO();
        return ad.buscar(id);
    }

    @RequestMapping(value = "/consumo", method = RequestMethod.PUT)
    public ConsumoDTO actualizarConsumo(@RequestBody ConsumoDTO consumo) {
        ConsumoDAO ad = new ConsumoDAO();
        return ad.actualizar(consumo);
    }

    @RequestMapping(value = "/consumo/{idtarjeta}", method = RequestMethod.POST)
    public ConsumoDTO agregarConsumoTarjeta(@RequestBody ConsumoDTO consumo, @PathVariable("idtarjeta") Integer idtarjeta) {
        ConsumoDAO ad = new ConsumoDAO();
        Integer idtjt = idtarjeta;
        ad.agregarATarjeta(consumo, idtjt);
        return consumo;
    }

    @RequestMapping(value = "/tarjeta", method = RequestMethod.POST)
    public TarjetaDTO agregarTarjeta(@RequestBody TarjetaDTO tarjeta) {
        TarjetaDAO ad = new TarjetaDAO();
        ad.agregar(tarjeta);
        return tarjeta;
    }

    @RequestMapping(value = "/tarjeta/{idcliente}", method = RequestMethod.POST)
    public TarjetaDTO agregarTarjetaCliente(@RequestBody TarjetaDTO tarjeta, @PathVariable("idcliente") Integer idcliente) {
        TarjetaDAO ad = new TarjetaDAO();
        Integer idclt = idcliente;
        ad.agregarACliente(tarjeta, idclt);
        return tarjeta;
    }

    @RequestMapping(value = "/tarjeta", method = RequestMethod.GET)
    public List<TarjetaDTO> buscarTarjetas() {
        TarjetaDAO ad = new TarjetaDAO();
        return ad.buscarTodos();
    }

    @RequestMapping(value = "/tarjeta/{id}", method = RequestMethod.GET)
    public TarjetaDTO buscarTarjeta(@PathVariable("id") Integer id) {
        TarjetaDAO ad = new TarjetaDAO();
        return ad.buscar(id);
    }

    @RequestMapping(value = "/tarjeta", method = RequestMethod.PUT)
    public TarjetaDTO actualizarTarjeta(@RequestBody TarjetaDTO tarjeta) {
        TarjetaDAO ad = new TarjetaDAO();
        return ad.actualizar(tarjeta);
    }

    @RequestMapping(value = "/tarjeta/{id}", method = RequestMethod.DELETE)
    public TarjetaDTO eliminarTarjeta(@PathVariable("id") Integer id) {
        TarjetaDAO ad = new TarjetaDAO();
        return ad.eliminar(id);
    }

    @RequestMapping(value = "/asesor", method = RequestMethod.POST)
    public AsesorDTO agregarAsesor(@RequestBody AsesorDTO asesor) {
        AsesorDAO ad = new AsesorDAO();
        ad.agregar(asesor);
        return asesor;
    }

    @RequestMapping(value = "/asesor", method = RequestMethod.GET)
    public List<AsesorDTO> buscarAsesores() {
        AsesorDAO ad = new AsesorDAO();
        return ad.buscarTodos();
    }

    @RequestMapping(value = "/asesor/{id}", method = RequestMethod.GET)
    public AsesorDTO buscarAsesor(@PathVariable("id") Integer id) {
        AsesorDAO ad = new AsesorDAO();
        return ad.buscar(id);
    }

    @RequestMapping(value = "/asesor", method = RequestMethod.PUT)
    public AsesorDTO actualizarAsesor(@RequestBody AsesorDTO asesor) {
        AsesorDAO ad = new AsesorDAO();
        return ad.actualizar(asesor);
    }

    @RequestMapping(value = "/asesor/{id}", method = RequestMethod.DELETE)
    public AsesorDTO eliminarAsesor(@PathVariable("id") Integer id) {
        AsesorDAO ad = new AsesorDAO();
        return ad.eliminar(id);
    }

    @RequestMapping(value = "/lista/clientes/tarjetas", method = RequestMethod.GET)
    public List<ClienteConTarjetaDTO> buscarClientesConTarjetas() {
        ClienteConTarjetaDAO ad = new ClienteConTarjetaDAO();
        return ad.buscarClientesConTarjetas();
    }

    @RequestMapping(value = "/historial/consumo/{numero}", method = RequestMethod.GET)
    public HistorialConsumoDTO buscarHistorialConsumo(@PathVariable("numero") String numero) {
        HistorialConsumoDAO ad = new HistorialConsumoDAO();
        return ad.buscarHistorial(numero);
    }
}
