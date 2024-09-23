package com.example.MiApi;

import com.example.MiApi.entities.*;
import com.example.MiApi.entities.enums.*;
import com.example.MiApi.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

@SpringBootApplication
public class MiApiApplication {

    @Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;
	@Autowired
	private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	@Autowired
	private FacturaRepository facturaRepository;
    @Autowired
	private UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	private PromocionDetalleRepository promocionDetalleRepository;
	@Autowired
	private PromocionRepository promocionRepository;
	@Autowired
	private ImagenRepository imagenRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	@Autowired
	private LocalidadRepository localidadRepository;
	@Autowired
	private DomicilioRepository domicilioRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private SucursalRepository sucursalRepository;
	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MiApiApplication.class, args);
		System.out.println("Servidor iniciado");
	}

	@Bean
	@Transactional
	CommandLineRunner init(ArticuloInsumoRepository articuloInsumoRepository,
						   	ArticuloManufacturadoRepository articuloManufacturadoRepository,
						   	ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository,
						   	CategoriaRepository categoriaRepository,
						   	DetallePedidoRepository detallePedidoRepository,
						   	FacturaRepository facturaRepository,
						   	UnidadMedidaRepository unidadMedidaRepository,
						   	PromocionDetalleRepository promocionDetalleRepository,
						   	PromocionRepository promocionRepository,
						   	ImagenRepository imagenRepository,
						   	UsuarioRepository usuarioRepository,
						   	EmpleadoRepository empleadoRepository,
						   	ClienteRepository clienteRepository,
						   	PaisRepository paisRepository,
						   	ProvinciaRepository provinciaRepository,
						   	LocalidadRepository localidadRepository,
						   	DomicilioRepository domicilioRepository,
						   	EmpresaRepository empresaRepository,
						   	SucursalRepository sucursalRepository,
						   	PedidoRepository pedidoRepository){
		return args -> {
			Imagen img1 = Imagen.builder()
					.denominacion("Imagen 1")
					.build();
			imagenRepository.save(img1);
			Imagen img2 = Imagen.builder()
					.denominacion("Imagen 2")
					.build();
			imagenRepository.save(img2);

			Categoria categoria1 = Categoria.builder()
					.denominacion("Carnes")
					.build();
			categoriaRepository.save(categoria1);

			Categoria categoria2 = Categoria.builder()
					.denominacion("Carnes vacunas")
					.categoriaPadre(categoria1)
					.build();
			categoriaRepository.save(categoria2);

			Categoria categoria3 = Categoria.builder()
					.denominacion("Hamburguesas")
					.build();
			categoriaRepository.save(categoria3);

			ArticuloInsumo articuloInsumo = ArticuloInsumo.builder()
					.precioCompra(3000.0)
					.stockActual(15)
					.stockMaximo(20)
					.esParaElaborar(true)
					.categoria(categoria3)
					.build();
			articuloInsumo.setDenominacion("Carne");
			articuloInsumo.setPrecioVenta(4000.0);
			articuloInsumo.getImagenesArticulos().add(img1);
			articuloInsumoRepository.save(articuloInsumo);


			ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder()
					.descripcion("Tomate, lechuga, queso, pan, carne")
					.preparacion("10 minutos la carne en la parrilla, tostar los panes, integrar ingredientes")
					.tiempoEstimadoMinutos(15)
					.build();
			articuloManufacturado.setDenominacion("Hamburguesa completa");
			articuloManufacturado.setPrecioVenta(6000.0);
			articuloManufacturado.setImagenesArticulos(new HashSet<>());
			articuloManufacturado.getImagenesArticulos().add(img2);
			articuloManufacturado.setCategoria(categoria3);
			articuloManufacturadoRepository.save(articuloManufacturado);

			ArticuloManufacturadoDetalle articuloManufacturadoDetalle = ArticuloManufacturadoDetalle.builder()
					.cantidad(4)
					.articuloManufacturado(articuloManufacturado)
					.articuloInsumo(articuloInsumo)
					.build();
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle);

			Pais pais1 = Pais.builder()
					.nombre("Pais 1")
					.build();
			paisRepository.save(pais1);

			Provincia prov1 = Provincia.builder()
					.nombre("Provincia 1")
					.pais(pais1)
					.build();
			provinciaRepository.save(prov1);

			Localidad loc1 = Localidad.builder()
					.nombre("Localidad 1")
					.provincia(prov1)
					.build();
			localidadRepository.save(loc1);

			Domicilio dom1 = Domicilio.builder()
					.calle("Calle 1")
					.numero(1234)
					.cp(1234)
					.localidad(loc1)
					.build();
			domicilioRepository.save(dom1);
			Domicilio dom2 = Domicilio.builder()
					.calle("Calle 2")
					.numero(5678)
					.cp(5678)
					.localidad(loc1)
					.build();
			domicilioRepository.save(dom2);

			Empresa empr1 = Empresa.builder()
					.nombre("Empresa 1")
					.cuil(12334555)
					.razonSocial("Empresa S.A")
					.build();
			empresaRepository.save(empr1);

			Sucursal suc1 = Sucursal.builder()
					.nombre("Sucursal 1")
					.casaMatriz(Boolean.FALSE)
					.domicilio(dom1)
					.horaApertura(LocalTime.of(8,30))
					.horaCierre(LocalTime.of(20,30))
					.empresa(empr1)
					.build();
			sucursalRepository.save(suc1);

			//Agregamos la sucursal a la lista de sucursales de las categorias
			categoria1.getSucursales().add(suc1);
			categoria2.getSucursales().add(suc1);
			categoria3.getSucursales().add(suc1);


			Usuario us1 = Usuario.builder()
					.auth0Id("pass")
					.userName("user")
					.build();
			usuarioRepository.save(us1);
			Usuario us2 = Usuario.builder()
					.auth0Id("pass2")
					.userName("user2")
					.build();
			usuarioRepository.save(us2);

			Empleado em1 = Empleado.builder()
					.sucursal(suc1)
					.build();
			em1.setNombre("Cinthia");
			em1.setApellido("Rigoni");
			em1.setTelefono("123456");
			em1.setEmail("prueba@gmail.com");
			em1.setFechaNacimiento("1992-05-27");
			em1.setImagenPersona(img1);
			em1.setUsuario(us1);
			em1.setRol(Rol.CAJERO);
			empleadoRepository.save(em1);

			Cliente cli1 = Cliente.builder().build();
			cli1.setNombre("Juan");
			cli1.setApellido("Fernandez");
			cli1.setTelefono("456789");
			cli1.setEmail("probando@gmail.com");
			cli1.setFechaNacimiento("1996-01-31");
			cli1.setImagenPersona(img2);
			cli1.setUsuario(us2);
			cli1.setRol(Rol.CLIENTE);
			cli1.getDomicilios().add(dom1);
			cli1.getDomicilios().add(dom2);
			clienteRepository.save(cli1);

			Pedido ped1 = Pedido.builder()
					.fechaPedido(LocalDate.of(2024,06,17))
					.sucursal(suc1)
					.cliente(cli1)
					.empleado(em1)
					.domicilio(dom1)
					.total(4000.0)
					.estado(Estado.PENDIENTE)
					.formaPago(FormaPago.EFECTIVO)
					.horaEstimadaFinalizacion(LocalTime.of(12,55))
					.tipoEnvio(TipoEnvio.DELIVERY)
					.totalCosto(2000.0)
					.build();
			pedidoRepository.save(ped1);

			DetallePedido det1 = DetallePedido.builder()
					.cantidad(5)
					.pedido(ped1)
					.articulo(articuloManufacturado)
					.subtotal(20000.0)
					.build();
			detallePedidoRepository.save(det1);

			Factura factura1 = Factura.builder()
					.formaPago(FormaPago.MERCADOPAGO)
					.pedido(ped1)
					.fechaFacturacion(LocalDate.of(2024,06,17))
					.mpPaymentId(1234)
					.mpMerchantOrderId(1234)
					.mpPreferenceId("Dinero en cuenta")
					.totalVenta(20000.0)
					.build();
			facturaRepository.save(factura1);

			UnidadMedida unidadMedida = UnidadMedida.builder()
					.denominacion("Kilogramo")
					.articulo(articuloInsumo)
					.build();
			unidadMedidaRepository.save(unidadMedida);


			PromocionDetalle promocionDetalle = PromocionDetalle.builder()
					.cantidad(2)
					.articulo(articuloManufacturado)
					.build();
			promocionDetalleRepository.save(promocionDetalle);

			Promocion promocion = Promocion.builder()
					.denominacion("2 x 1 en hamburguesas")
					.promocionDetalles(new HashSet<>())
					.tipoPromocion(TipoPromocion.PROMOCION)
					.descripcionDescuento("Llevas 2 hamburguesas por el precio de 1")
					.fechaDesde(LocalDate.of(2024,06,17))
					.fechaHasta(LocalDate.of(2024,07,17))
					.precioPromocional(4000.0)
					.build();
			promocion.getImagenesPromocion().add(img1);
			promocion.getPromocionDetalles().add(promocionDetalle);
			promocion.getSucursales().add(suc1);
			promocionRepository.save(promocion);

		};
	}
}
