package cl.cgr.siaper.ru.api.administracion_servicios_publicos.hist.constant;

import java.io.Serializable;

public class Constantes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5065148322977413467L;

	/**
	 * Constante ACTIVO = S
	 */
	public static final String ACTIVE_YES = "S";

	/**
	 * Constante ACTIVO = N
	 */
	public static final String ACTIVE_NO = "N";

	/**
	 * Constante LEY
	 */
	public static final String LEY = "LEY";

	/**
	 * Constante ARTICULO
	 */
	public static final String ARTICULO = "ARTICULO";

	/**
	 * Constante REQUISITO
	 */
	public static final String REQUISITO = "REQUISITO";

	/**
	 * Constante GRILLA = G
	 */
	public static final String GRILLA = "G";

	/**
	 * Constante LISTA = L
	 */
	public static final String LISTA = "L";

	/**
	 * Constante AGREGAR = A
	 */
	public static final String AGREGAR = "A";

	/**
	 * Constante ELIMINAR = E
	 */
	public static final String ELIMINAR = "E";

	/**
	 * Constante SUPLIR = S
	 */
	public static final String SUPLIR = "S";

	/**
	 * Constante NOAPLICA = N
	 */
	public static final String NO_APLICA = "N";

	public static final String ORIGEN_SIAPER = "S";

	public static final String ORIGEN_REGISTRO_CIVIL = "R";

	public static final String ORIGEN_NINGUNO = "N";

	public static final String UNIVERSIDAD = "UNIVE";

	public static final String ESTADO_BORRADOR = "BORRA";

	public static final String ESTADO_PENDIENTE_ENVIO_FIRMANTE = "PEENV";

	public static final String ESTADO_PENDIENTE_ENVIO_VISACION = "PEENVVIS";

	public static final String ESTADO_DECLARACION_ANTECEDENTES = "DECAN";

	public static final String ESTADO_PENDIENTE_FIRMA = "PEFIR";

	public static final String ESTADO_PENDIENTE_VISACION = "PEVIS";

	public static final String ESTADO_FIRMADO = "FIRMADO";

	public static final String ESTADO_VISADO = "VISADO";

	public static final String ESTADO_DEVUELTO_MINISTRO = "DEVMIN";

	public static final String ESTADO_ESTUDIO = "ESTUD";

	public static final String ESTADO_REPRESENTADO = "REPRE";

	public static final String ESTADO_TOMADO_RAZON = "TOMRA";

	public static final String ESTADO_NO_FIRMADO = "NOFIRMA";

	public static final String ESTADO_PROC_FIRMA_REPRE_JAREA = "PROCFIRMA-REPRE-JAREA";

	public static final String ESTADO_PROC_FIRMA_TOMRA_JAREA = "PROCFIRMA-TOMRA-JAREA";

	public static final String ESTADO_PROC_FIRMA_REPRE_JDPAE = "PROCFIRMA-REPRE-JDPAE";

	public static final String ESTADO_PROC_FIRMA_TOMRA_JDPAE = "PROCFIRMA-TOMRA-JDPAE";

	public static final String ESTADO_PROC_FIRMA_REPRE_CONTR = "PROCFIRMA-REPRE-CONTR";

	public static final String ESTADO_PROC_FIRMA_TOMRA_CONTR = "PROCFIRMA-TOMRA-CONTR";

	public static final String ESTADO_ENVIADO_OTRA_DIVISION = "ENVOTDIVISION";

	public static final String ESTADO_ENVIADO_REVISOR = "ENVREVISOR";

	public static final String ESTADO_DEVUELTO_ANULAR = "ENVANU";

	public static final String ESTADO_ESTUDIADO_TOMAR_RAZON = "EST-TOMRA";

	public static final String ESTADO_ESTUDIADO_REPRESENTADO = "EST-REPRE";

	public static final String ESTADO_INGRESADO_CGR = "INGRESADOCGR";

	public static final String ESTADO_REGISTRADO = "REGISTRADO";

	public static final String ESTADO_PROCESO_REG_CMASIVA = "PROC-REG-CMASIVA";
	public static final String ACCION_PROCESO_REG_CMASIVA = "PROCECMAS";
	public static final String ESTADO_SORE = "SORE";

	public static final String ESTADO_RETI = "RETI";

	public static final String COMPROBACION = "C";

	public static final String ACCION = "A";

	public static final String TIPO_SERVICIO_CGR = "CONTR";

	public static final String TIPO_MATERIA_NORMAL = "NORMA";

	public static final String TIPO_MATERIA_REEMPLAZO = "RECO";

	public static final String TIPO_MATERIA_SUPLENCIA = "SUND";

	public static final String TIPO_MATERIA_DESI_CONTRATA = "DECO";

	public static final String TIPO_MATERIA_DEJA = "DEEF";

	public static final String TIPO_MATERIA_PRORROGA = "PROMA";

	/**
	 * Formato usado para las fechas de los formularios
	 */
	public static final String FECHA_FORMATO_RESP_FORMULARIO = "yyyy-MM-dd";

	public static final String FORMULARIO_NO_INICIADO = "NI";

	public static final String FORMULARIO_CON_ERRORES = "IE";

	public static final String FORMULARIO_COMPLETO = "IC";

	/* Código de la tabla ACCIONES_DOCUMENTOS */
	public static final String ELIMINA_CASO_DOCUMENTO = "ELICASODOC";

	public static final String NUEVO_DOCUMENTO = "NEWDOC";

	public static final String NUEVO_CASO_DOCUMENTO = "NEWCASODOC";

	public static final String MODIFICAR_CASO_DOCUMENTO = "MODCASODOC";

	public static final String FIRMAR_DOCUMENTO = "FIRMARDOC";

	public static final String ENVIA_DOCUMENTO_MINISTRO_FE = "ENVMINIFE";

	public static final String ENVIA_FIRMANTE = "ENVIOFIRM";

	public static final String REASIGNAR_FIRMANTE = "REASIGFIRM";

	public static final String REASIGNAR_VISADOR = "REASIGVIS";

    public static final String ENVIA_A_OTRO_SERVICIO = "ENVOTROSERV";

    public static final String DEVUELTO_CREADOR = "DEVCREADOR";

	public static final String DEVUELTO_OTRO_SERVICIO = "DEVOTRS";

	public static final String FIRMA_VISADA = "VISARFIRM";

	public static final String FIRMA_NO_VISADA = "NOVISFIRM";

	public static final String ENVIO_CGR = "ENVCGR";

	public static final String ENVIO_ESTUDIO = "ENVEST";

	public static final String RECHAZO_FIRMA_SUBSECRETARIO = "NOFIRMSUB";

	public static final String ENVIO_FIRMANTE_SUBSECR_MINIST = "ENFISUBMIN";

	public static final String DOCUMENTO_TOMADO_RAZON = "TOMRAZ";

	public static final String DOCUMENTO_REPRESENTADO = "REPRE";

	public static final String DOCUMENTO_ENVIADO_ANALISTAWAR = "ENVANA";

	public static final String DOCUMENTO_REENVIADO_ANALISTAWAR = "RENVANA";

	public static final String DOCUMENTO_ENVIADO_JEFEWAR = "ENVJEF";

	public static final String DOCUMENTO_ENVIADO_OTRO_SERVICIO = "ENVOTS";

	public static final String DOCUMENTO_ENVIADO_VISACION = "ENVVIS";

	public static final String DOCUMENTO_VISADO = "VISARDOC";

	public static final String DOCUMENTO_VISADO_ANTECEDENTES = "VISARANT";

	public static final String DECLARACION_VISACION_ACEPTADA = "DECLVIS";

	public static final String DECLARACION_VISACION_RECHAZADA = "NODECVIS";

	public static final String FIRMA_SUBSECR_REALIZADA = "FIRMSUB";

	public static final String FIRMA_MINISTRO_REALIZADA = "FIRMMINIS";

	public static final String ENVIADO_JEFE_AREA_REPRE = "JAREAREPRE";

	public static final String ENVIADO_JEFE_AREA_TOMRA = "JAREATOMRA";

	public static final String ENVIADO_JEFE_DPAE_REPRE = "JDPAEREPRE";

	public static final String ENVIADO_JEFE_DPAE_TOMRA = "JDPAETOMRA";

	public static final String ENVIADO_CONTRALOR_REPRE = "CONTRREPRE";

	public static final String ENVIADO_CONTRALOR_TOMRA = "CONTRTOMRA";

	public static final String ENVIADO_A_OTRA_CONTRALORIA = "ENVOTCTRLR";

	public static final String DEVUELTO_JEFE_AREA = "JAREADEVOL";

	public static final String DEVUELTO_JEFE_DPAE = "JDPAEDEVOL";

	public static final String DEVUELTO_CONTRALOR = "CONTRDEVOL";

	public static final String ENVIADO_JEFE_AREA_AUTOMATICO = "ENVJAREA";

	public static final String DOCUMENTO_REPRESENTADO_DESPUES_ESTUDIO = "REPRE-ESTU";

	public static final String DOCUMENTO_TOMADO_RAZON_DESPUES_ESTUDIO = "TOMRA-ESTU";

	public static final String ENVIADO_OTRA_DIVISION = "ENVOTDIVIS";

	public static final String ENVIADO_REVISOR = "ENVREVISOR";

	public static final String ENVIADO_OTRO_REVISOR = "ENVOTROREV";
	public static final String EN_ESTUDIO_A_SOLICITUD_RETIRO = "ESTSORE";

	public static final String SOLICITUD_RETIRO_A_RETIRADO = "SORERETI";

	public static final String SOLICITUD_RETIRO_A_EN_ESTUDIO = "SOREEST";

	/* Causales de Suplencia */
	public static final String CODIGO_CAUSAL_SUPLENCIA_EN_CARGO_NO_SERVIDO_POR_EL_TITULAR = "SUPLENTE - SUPLENCIA EN CARGO NO SERVIDO POR EL TITULAR";

	public static final String CODIGO_CAUSAL_SUPLENTE_POR_CARGO_VACANTE = "SUPLENTE - SUPLENCIA POR CARGO VACANTE";

	public static final String CODIGO_MATERIA_SUPLENCIA_CARGO_NO_SERVIDO_TITULAR = "sup_no_serv_ok";

	public static final String CODIGO_MATERIA_SUPLENCIA_CARGO_VACANTE = "sup_vac_ok";

	public static final String CODIGO_MATERIA_NOMBRAMIENTO_ADP = "nom_tit_adp_ok";

	public static final String CODIGO_MATERIA_NOMBRAMIENTO_TITULAR = "nom_tit_ok";

	public static final String CODIGO_MATERIA_PRORROGA_NOMBRAMIENTO_TRANSITORIO_ADP = "pro_tit_adp_ok";

	public static final String CODIGO_MATERIA_RENOVACION_NOMBRAMIENTO_ADP = "ren_tit_adp_ok";

	public static final String CODIGO_MATERIA_CONTRATO_REEMPLAZO = "reemplazo_ok";

	public static final String CODIGO_MATERIA_CONTRATO_REEMPLAZO_2019 = "reemplazo_2019_ok";

	public static final String CODIGO_MATERIA_ASCENSO_PLANTA_AUXILIAR = "asc_auxil_ok";

	public static final String CODIGO_MATERIA_ASCENSO_PLANTA_ADMINISTRATIVA = "asc_admin_ok";

	public static final String CODIGO_MATERIA_TERMINO_CONTRATO_HONORARIO_SUMA_ALZADA = "cese_con_suma_ok";

	public static final String CODIGO_MATERIA_TERMINO_CONTRATO_HONORARIO_ASIMILADO_GRADO = "cese_con_grad_ok";

	public static final String CODIGO_MATERIA_CONTRATOS_PERSONAS_NATURALES_HONORARIO_ASIMILADO_GRADO = "hono_grad_ok";

	public static final String CODIGO_MATERIA_PROMOCION = "promoc_ok";

	public static final String CODIGO_MATERIA_PRORROGA_DESIGNACION_CONTRATA = "pror_contrata_ok";

	public static final String CODIGO_MATERIA_PRORROGA_DESIGNACION_CONTRATA_TRE = "porr_contrata_tre";

	public static final String CODIGO_MATERIA_COMISION_EXTRANJERO = "com_extranjero";

	public static final String CODIGO_MATERIA_MED_EXP_ESTATUTO = "med_expul_estatuto";

	public static final String CODIGO_ELEM_CONDUCTA_ACOSO = "conducta_acoso";

	public static final String ENTIDAD_INTEROPERABLE_SIAPER = "SIAP";

	public static final String ENTIDAD_INTEROPERABLE_MINI_EDUCACION = "MIED";

	public static final String ENTIDAD_INTEROPERABLE_MINI_RELACIONES_EXTERIORES = "MIRE";

	public static final String HECHO_INICIAL_DOTACION = "ws_dotacion_selec()";

	public static final String WEB_SERVICE_DOTACION = "ws_nhi_dotacion_selec(?s, ?s, ?s, ?s, ?s, ?s, ?s, ?s)";

	public static final String HECHO_INICIAL_SUBCARGO = "ws_subcargo_selec()";

	public static final long TAMANIO_MAX_FOTOGRAFIA = 46080;

	public static final String MINISTRO_FE = "MINISTRO_FE";

	public static final String FIRMANTE = "FIRMANTE";

	public static final String CREADOR = "CREADOR";

	public static final String JEFE_WARN = "JEFE_WARN";

	public static final String ANALISTA_WARN = "ANALISTA_WARN";

	public static final String ADMINISTRADOR = "ADMINISTRADOR";

	public static final String ADMINISTRADOR_CARGA_MASIVA = "ADM_CARGA_MASIVA";

	public static final String MESA_AYUDA_ADM = "MESA_AYUDA_ADM";

	public static final String MESA_AYUDA_TRA = "MESA_AYUDA_TRA";

	public static final String JEFE_AREA = "JEFE_AREA";

	public static final String JEFE_DPAE = "JEFE_DPAE";

	public static final String SUBCONTRALOR = "SUBCONTRALOR";

	public static final String CONTRALOR = "CONTRALOR";

	public static final String OTRA_DIVISION = "OTRA_DIVISION";

	public static final String REVISOR = "REVISOR";

	public static final String AUDITOR = "AUDITOR";

	public static final String SUPERVISOR = "SUPERVISOR";
	public static final String SUPERVISOR_CGR = "SUPERVISOR_CGR";

	public static final String GESTOR = "GESTOR";

	public static final String FIRMANTE_ESTAMPA = "FIRMANTE_ESTAMPA";

	public static final Long CODIGO_MINISTERIO_EDUCACION = 7L;

	public static final String ESTUDIOS_FORMALES = "ESTUDIOS FORMALES";

	public static final Short NATURALEZA_ADP_NIVEL_1 = new Short("1");

	public static final Short NATURALEZA_ADP_NIVEL_2 = new Short("2");

	public static final String CALIDAD_S_TRANSITORIO = "NOMBRAMIENTO TRANSITORIO Y PROVISIONAL ADP";
	public static final String CALIDAD_TRANSITORIO = "48";

	public static final String CALIDAD_S_PRORROGA_TRANSITORIO = "PRÓRROGA NOMBRAMIENTO TRANSITORIO Y PROVISIONAL ALTA DIRECCIÓN PÚBLICA";
	public static final String CALIDAD_PRORROGA_TRANSITORIO = "53";

	public static final String ANULAR_DOCUMENTO = "ANULARDOC";
	public static final String ESTADO_ANULADO = "ANULADO";

	public static final int TIPO_DOCUMENTO_DECRETO = 31;

	public static final int TIPO_DOCUMENTO_DECRETO_EXENTO = 42;

	public static final int TIPO_DOCUMENTO_RESOLUCION = 32;

	public static final int TIPO_DOCUMENTO_RESOLUCION_EXENTA = 41;

	public static final String prefijoAtomo = "atomo_";

	// Cuando un valor de un campo del formulario tiene mas de una etiqueta para
	// mostrar (por ejemplo en el caso de las tablas),
	// las distintas etiquetas de un valor se separan mediante este separador
	public static final String SEPARADOR_LABEL_MULTI = "#;;#";
	// En la descripcion de un datoCaso se almacena la etiqueta de los valores del
	// formulario. Como hay campos del formulario con mas de un valor
	// se almacenaran sus distintas etiquetas separadas por este separador
	public static final String SEPARADOR_DESCRIPCION_MULTI = "_-_-";

	// Variables que pueden ser usadas en el contenido de los emails que genera la
	// aplicacion y que seran
	// substituidas por el valor correspondiente cuando se envie el email
	public static final String VAR_EMAIL_NUM_DOC = "#{numDocuFirmado}";
	public static final String VAR_EMAIL_FEC_CREACION = "#{fechaCreacion}";
	public static final String VAR_EMAIL_FEC_TRAMITACION = "#{fechaTramitacion}";
	public static final String VAR_EMAIL_TIPO_DOC = "#{tipoDocumento}";
	public static final String VAR_EMAIL_SERVICIO = "#{servicio}";
	public static final String VAR_EMAIL_RUN = "#{runInteresado}";
	public static final String VAR_EMAIL_USUARIO = "#{usuario}";

	// Posibles resultados de la toma de razon automatica
	public static final String RESULTADO_TOMARA_TOMADORAZON = "T";
	public static final String RESULTADO_TOMARA_REPRESENTADO = "R";
	public static final String RESULTADO_TOMARA_ESTUDIO = "E";
	public static final String RESULTADO_REGISTRADO = "A";

	public static final Long REGION_METROPOLITANA_SIAPER = new Long(13);
	// public static final Long REGION_METROPOLITANA_SIAPER = new Long(921);
	public static final Long REGION_METROPOLITANA_I_SIAPER = new Long(916);
	public static final Long REGION_METROPOLITANA_II_SIAPER = new Long(917);

	// Codigo TRA de Contraloria General de la Republica
	public static final Long CONTRALORIA_GENERAL_REPUBLICA = new Long(1);
	// Codigo TRA de Region Metropolitana
	public static final Long COD_REGION_METROPOLITANA_SIAPER = new Long(15);
	// Codigo TRA de Region Metropolitana DPSP
	public static final Long REGION_METROPOLITANA_DPSP_SIAPER = new Long(23);
	// Codigo TRA Entidad Privada 11787
	public static final Long ENTIDAD_PRIVADA = new Long(11787);
	public static final Long ENTIDAD_CORPORACION = new Long(11788);
	public static final String PRIVADO = "V";

	/**
	 * Abreviatura de campo Si en BBDD
	 */
	public static final String ABREVIATURA_SI = "S";

	/**
	 * Abreviatura de campo No en BBDD
	 */
	public static final String ABREVIATURA_NO = "N";

	/**
	 * Abreviatura de sexo femenino
	 */
	public static final String ABREVIATURA_SEXO_FEMENINO = "F";

	/**
	 * Codigo de sexo feminino
	 */
	public static final String ABREVIATURA_COD_SEXO_FEMENINO = "2";

	/**
	 * Abreviatura de sexo masculino
	 */
	public static final String ABREVIATURA_SEXO_MASCULINO = "M";

	/**
	 * Codigo de sexo masculino
	 */
	public static final String ABREVIATURA_COD_SEXO_MASCULINO = "1";

	/**
	 * Abreviatura warnings estudio incompatible
	 */
	public static final int CODIGO_WARNING_ESTUDIO_INCOMPATIBLE = 4;

	/**
	 * Configuracion donde almacenamos el codigo de conserva cargo
	 */
	public static final String CODIGO_CONSERVA_CARGO = "mantiene_cargo";

	/**
	 * Codigo de la del motivo de dotacion otros
	 */
	public static final String CODIGO_MOTIVO_OTROS = "1";
	/**
	 * Codigo de Muestra combos planta, cargo, grado para modificacion
	 */
	public static final String CODIGO_COMBO_MODIF = "1";

	/**
	 * Codigo que deja bloqueado registro si es NO Vigente
	 */
	public static final String CODIGO_COMBO_NOVIG = "2";
	/**
	 * Codigo de la del motivo de dotacion otros
	 */
	public static final String CODIGO_DOTACION_OK = "OK";

	/**
	 * Codigo de la del motivo de dotacion otros
	 */
	public static final String CODIGO_DOTACION_ERROR = "ERROR";

	/**
	 * Codigo de la del motivo de dotacion otros
	 */
	public static final String AUDIT_CGR = "AUDIT_CGR";

	// Posibles resultados del analisis de los analistas
	public static final String ESTADO_ESTUDIO_TOMADORAZON = "T";
	public static final String ESTADO_ESTUDIO_REPRESENTADO = "R";
	public static final String ESTADO_ESTUDIO_ESTUDIO = "E";

	public static final String CODIGO_URL_HOJA_VIDA = "verHojaVida";

	public static final String CODIGO_MATERIA_MODIFICA = "materiaModificaRectifica";

	public static final String ACTOS_EN_MATERIA_PERSONAL = "Actos Administrativos en materias de personal";

	public static final String ACTOS_EN_BENEFICIOS = "Actos Administrativos sobre beneficios previsionales y remuneratorios";

	public static final String ACTOS_EN_OTRAS_MAT = "Otros actos administrativos en materias de personal";

	/**
	 * Codigo de la calidad contractual en honorarios
	 */
	public static final String CODIGO_CALIDAD_HONORARRIO = "HONO";
	/**
	 * Codigo perfil Diario oficial
	 */
	public static final String DIARIO_OFICIAL = "DIARIO-OFICIAL";

	public static final String ENVIA_DOCUMENTO_BANDEJA_DIARIO = "ENVDIARIO";

	public static final String ENVIA_DOCUMENTO_PUBLICACION = "ENVPUB";

	public static final String ENVIA_DOCUMENTO_NOPUBLICACION = "ENVNOPUB";

	public static final String ESTADO_DIARIO_PUBLICADO = "PUBLI";

	public static final String ESTADO_DIARIO_PENDIENTE = "PENPU";

	public static final String ESTADO_DIARIO_NO_PUBLICADO = "NOPUB";

	// CONSTANTES VALORES DE CELDA DEL EXCEL
	public static final String CELL_TYPE_NUMERIC = "NUMERIC";

	public static final String CELL_TYPE_TEXT = "TEXT";

	public static final String CELL_TYPE_DATE = "DATE";

	public static final String CELL_TYPE_BOOLEAN = "BOOLEAN";
	///////////////////////////////////////

	// CONSTANTES EXTENSION DEL EXCEL
	public static final String EXTENSION_EXCEL_ANTIGUO = "xls";
	public static final String EXTENSION_EXCEL_NUEVO = "xlsx";
	///////////////////////////////////////

	public static final String CODIGO_ACCION_REGENERACION = "REGENE";

	/**
	 * Códigos de materia, para luego agregar el panel de suplencia a los preview de
	 * estas.
	 */

	public static final String CODIGO_MATERIA_CONTRATO_EN_REMPLAZO_POR_UN_PERIODO_IGUAL_O_INFERIOR_A_3_MESES = "reemplazo_exento";

	public static final String CODIGO_MATERIA_SUPLENCIA_EN_CARGO_DE_EXCLUSIVA_CONFIANZA_POR_AUSENCIA_TITULAR = "sup_ex_conf_no_serv";

	public static final String CODIGO_MATERIA_SUPLENCIA_CARGO_NO_SERVIDO_TITULAR_PERSONAL_AJENO_SERVICIO = "sup_no_serv_ok";

	public static final String CODIGO_MATERIA_SUPLENCIA_CARGO_NO_SERVIDO_TITULAR_MISMO = "sup_noserv_mismo";

	public static final String CODIGO_MATERIA_SUPLENCIA_CARGO_NO_SERVIDO_TITULAR_2019 = "sup_notit_2019";

	public static final String CODIGO_MATERIA_ESTUDIOS = "estudios";

	/////////////////////////////////////////////////////////////////////////////////////////////
	/// Constantes para el nivel de detalle de guardado de la carga de tiempos de un
	///////////////////////////////////////////////////////////////////////////////////////////// formulario///
	/////////////////////////////////////////////////////////////////////////////////////////////
	public static final String MEDICION_CARGA_DESACTIVADA = "0";
	public static final String MEDICION_CARGA_BAJA = "1";
	public static final String MEDICION_CARGA_MEDIA = "2";

	///////////////////////////////////////////////////////////////////////
	/// Constantes tipo de lectura a realizar de la base de conocimiento ///
	///////////////////////////////////////////////////////////////////////
	public static final String BASE_CONOCIMIENTO_PRECARGADA = "P";
	public static final String BASE_CONOCIMIENTO_LECTURA = "L";

	///////////////////////////////////////////////////
	/// Constantes tipo de lectura del formulario ///
	///////////////////////////////////////////////////
	public static final String LECTURA_FORMULARIO_INICIAL = "I";
	public static final String LECTURA_FORMULARIO_SEGUNDA_CARGA = "C";

	/**
	 * Texto del mensaje de publicacion de los distintos formularios
	 */
	public static final String COMENTARIO_PUBLICACION_CLONACION = "Formulario clonado del formulario ";

	///////////////////////////////////////////////////////////////////////
	/// Constantes para la vuelta de pagimas desde la publicacion form ///
	///////////////////////////////////////////////////////////////////////
	public static final String VISTA_VUELVE_MATERIAS = "vistaMaterias";
	public static final String VISTA_VUELVE_ESTADOS_PUBLICACION = "vistaEstado";

	///////////////////////////////////////////////////////////////////////
	/// Constantes para el calculo del csv ///
	///////////////////////////////////////////////////////////////////////
	public static final String CLAVE_CSV = "keyCSV";
	public static final String ALGORITMO_CSV = "algorithmCSV";
	public static final String ID_APLICACION_CSV = "idAplicacion";

	public static final String ESTADO_VALIDADO = "VALIDADO";
	public static final String ESTADO_MOD_CASO = "MOD_CASO";
	public static final String ESTADO_NUEVO_CASO = "NUEVO_CASO";

	public static final String BENEFICIO_OTROS = "Otros";

	public static final String VAR_PETICION_MASIVA = "#{numPeticionMasiva}";

	public static final String VAR_ERROR_CARGA_MASIVA = "#{errorPeticionMasiva}";

	public static final String VAR_SUBIDA_PLANILLA = "#{numPeticionMasiva}";

	// ///////////////////////////////////////////////////////////////////////
	// ///Constantes de materias para cu de preview ///
	// ///////////////////////////////////////////////////////////////////////

	public static final String CODIGO_MATERIA_COMETIDO_FUNCIONARIO = "cometido_func";
	public static final String CODIGO_MATERIA_COMETIDO_FUNCIONARIO_EN_EL_EXTERIOR = "cometido_minrel";
	public static final String CODIGO_MATERIA_COMISION_DE_SERVICIO_AL_EXTRANJERO = "com_extranjero";
	public static final String CODIGO_MATERIA_DESTINACION_FUERA_DEL_PAIS = "destin_fuera";
	public static final String CODIGO_MATERIA_COMISION_DE_SERVICIO_DENTRO_DEL_PAIS = "com_pais";
	public static final String CODIGO_MATERIA_DESTINACION_DENTRO_DEL_PAIS = "destin_dentro";
	public static final String CODIGO_MATERIA_CALIFICACION_DE_FUNCIONES_CRITICAS = "asig_func_criticas";
	public static final String CODIGO_MATERIA_ENCOMENDACION_DE_FUNCIONES_DIRECTIVAS = "enco_funciones";
	public static final String CODIGO_MATERIA_ESTABLECIMIENTO_DE_ORDEN_DE_SUBROGACION = "subroga";
	public static final String CODIGO_MATERIA_OTORGAMIENTO_DE_PENSIONES_NO_CONTRIBUTIVAS = "pen_exn_privado";
	public static final String CODIGO_MATERIA_OTORGAMIENTO_DE_BECAS_LEY_15076 = "beca_15076";
	public static final String CODIGO_MATERIA_RECONOCIMIENTO_DE_FUNCIONARIO_DE_HECHO = "regu_func_hecho";
	public static final String CODIGO_MATERIA_DECLARACION_DE_INHABILIDAD_ADMINISTRATIVA = "inhab_adm";

	/*
	 * Constantes nuevo modelo control de personal 2019
	 */
	public static final String CODIGO_MATERIA_CESE_ADP_RENUNCIA_NO_VOLUNTARIA_TRE_2019 = "ces_adp_nov_tre_2019";
	public static final String CODIGO_MATERIA_COMISION_DP_CUADRO_PERMANENTE_2019 = "com_pais_cp_2019";
	public static final String CODIGO_MATERIA_OTORGAMIENTO_DE_BENEFICIOS_REMUNERATORIOS_QUE_REQ_CP_2019 = "asig_titulo_cp_2019";
	public static final String CODIGO_MATERIA_CESE_DE_FUNCIONES_ADP_DECLARACION_VACANCIA_NP_REN_TRE_2019 = "ces_adpnore_tre_2019";
	public static final String CODIGO_MATERIA_CESE_DE_FUNCIONES_DECLARACION_VACANCIA_NP_REN_TRE_2019 = "cese_titnor_tre_2019";
	public static final String CODIGO_MATERIA_CESE_DE_FUNCIONES_CONTRATA_VACANCIA_PERD_REQ_ING_ADM_EST = "cese_perdidareq_tre";
	public static final String CODIGO_MATERIA_CESE_DE_FUNCIONES_CONTRATA_VACANCIA_PERD_REQ_ING_ADM_EST_2019 = "cese_perdreqtre_2019";
	public static final String CODIGO_MATERIA_CESE_DE_FUNCIONES_TITULARES_VACANCIA_PERD_REQ_ING_ADM_EST_2019 = "cestit_perdtre_2019";
	public static final String CODIGO_MATERIA_CESE_DE_FUNCIONES_TITULARES_POR_RENUNCIA_VOLUNTARIA_TRE_2019 = "ces_tit_nvo_tre_2019";
	public static final String CODIGO_MATERIA_DESIGNACION_A_CONTRATA_DE_PROFESIONALES_FUNCIONARIOS_2019 = "contra_profunc_2019";
	public static final String CODIGO_MATERIA_DESIGNACION_A_CONTRATA_EN_REEMPLAZO_TRE_2019 = "reemplazo_ok_2019";
	public static final String CODIGO_MATERIA_DESTINACION_DENTRO_DEL_PAIS_CP_2019 = "dest_pais_cp_2019";
	public static final String CODIGO_MATERIA_DESTINACION_FUERA_DEL_PAIS_CP_2019 = "dest_fuera_cp_2019";
	public static final String CODIGO_MATERIA_COMISION_SERVICIO_AL_EXTRANJERO_CP_2019 = "com_extran_cp_2019";
	public static final String CODIGO_MATERIA_RETIRO_ABSOLUTO_TRE_2019 = "ret_abs_tre_2019";
	public static final String CODIGO_MATERIA_DESIGNACION_A_CONTRATA_DECRETO_LEY_1608_TRE_2019 = "contra_tre_1608_2019";
	public static final String CODIGO_MATERIA_NOMBRAMIENTO_TITULAR_NO_PRECEDIDO_POR_CP_INGRESO_A_TRE_2019 = "nom_tit_tre_2019";
	public static final String CODIGO_MATERIA_NOMBRAMIENTO_TITULAR_PROFESORES_INSTITUCIONALES = "nom_prof_inst";
	public static final String CODIGO_MATERIA_CONTRATO_EN_REEMPLAZO_2019 = "reemplazo_2019_ok";
	public static final String CODIGO_MATERIA_NOMBRAMIENTO_DIRECTO_TRE_2019 = "nom_direct8_tre_2019";
	public static final String CODIGO_CONTRATA_INDEFINIDA_TRE_2019 = "contrata_indef_2019";
	public static final String CODIGO_CONTRATA_SERVICIOS_LOCALES_EDUCACION_TRE_2019 = "contrata_sle_2019";
	public static final String CODIGO_MATERIA_CESE_DE_FUNCIONES_DECLARACION_VACANCIA_SALUD_INCOMP_TRE_2019 = "cescon_inc_tre_2019";
	public static final String CODIGO_MATERIA_CONTRATA_TRE_2019 = "contrata_tre_2019";
	public static final String CODIGO_MATERIA_ASCENSO_TRE = "ascenso_tre";
	public static final String CODIGO_MATERIA_ASCENSO_TRE_2019 = "ascenso_tre_2019";
	public static final String CODIGO_MATERIA_DESIGNACION_CONTRATA_2019 = "desig_contrata_2019";
	public static final String CODIGO_MATERIA_DECISION_NO_PRORROGAR = "Dec_no_renov_contrat";
	public static final String CODIGO_MATERIA_CONTRATA_DECLARACION_VACANCIA_RENUNCIA_2019 = "cese_con_noren_2019";

	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Materia: Nombramiento Titular Profesionales Funcionarios TRE
	 */
	public static final String CODIGO_MATERIA_NOMBRAMIENTO_TITULAR_PROFESIONALES_FUNCIONARIOS_TRE = "nom_tit_prof_func";
	/**
	 * Materia: Designación a Contrata de Profesionales Funcionarios superior a 3
	 * meses TRE
	 */
	public static final String CODIGO_MATERIA_CONTRATA_PROF_FUNC_SUPERIOR_3M_TRE = "cont_prof_fc_sup_tre";
	/**
	 * Materia: Cese de asignación de funciones críticas
	 */
	public static final String CODIGO_MATERIA_CESE_ASIGNACION_FUNCIONES_CRITICAS = "cese_func_critic";
	/**
	 * Materia: Cese de encomendación de funciones directivas
	 */
	public static final String CODIGO_MATERIA_CESE_ENCOMENDACION_FUNCIONES_DIRECTIVAS = "cese_encomen";
	/**
	 * Materia: Declaración de Inhabilidad Administrativa
	 */
	public static final String CODIGO_MATERIA_DECLARACION_INHABILIDAD_ADMINISTRATIVA = "inhab_adm";
	/**
	 * Materia: Establecimiento de orden de subrogación, cuando recaiga en
	 * funcionarios determinados
	 * y se altere el orden jerárquico regular
	 */
	public static final String CODIGO_MATERIA_ESTABLECIMIENTO_ORDEN_SUBROGACION = "subroga";
	/**
	 * Materia: Pensiones no contributivas ley N° 19.234 exonerados políticos del
	 * sector privado
	 */
	public static final String CODIGO_MATERIA_PENSIONES_NO_CONTRIBUTIVAS_LEY_19234 = "pen_exn_privado";
	/**
	 * Materia: Otorgamiento de beneficios remuneratorios que requieren contar con
	 * un título profesional
	 */
	public static final String CODIGO_MATERIA_OTORGAMIENTO_BENEFICIOS_REQUIEREN_TITULO_PROFESIONAL = "reconoce_titulo";

	public static final String CODIGO_MATERIA_CESE_CODIGO_TRABAJO_CAUSAL_REN_TRABAJADOR_TRE = "cesecod_renuncia_tre";

	public static final String ESTADO_ESTUDIO_EXTERNO = "En estudio";

	// Cu bandeja contralor
	public static final String METODO_HSM_INTERNO = "HSM_INTERNO";
	public static final String METODO_HSM_EXTERNO = "HSM_EXTERNO";
	public static final String CODIGO_SERVICIO_CGR = "56";
	public static final String VAR_FIRMA_CONTRALOR_EXITOSOS = "#{numContralorFirmados}";
	public static final String VAR_FIRMA_CONTRALOR_ERROR = "#{numContralorError}";
	public static final String VAR_FIRMA_CONTRALOR_TOTAL = "#{numContralorTotal}";
	// ESTADO
	public static final String ESTADO_PROCESO_FIRMA_CONTRALOR = "PROFIRCONT";
	// ACCION
	public static final String PROCESO_FIRMA_CONTRALOR = "PROCEFIRMA";
	public static final String FIRMANTE_CGR = "FIRMANTE_CGR";
	// Perfil descarga documento firma
	public static final String DESCARGA_FIRMA = "DESCARGA_FIRMA";

	// SOLO VALIDO PARA PRUEBAS EN AMBIENTE DE DESARROLLO. CAMBIAR VALOR A "NOK"
	// CUANDO SE HAGA EL PASO A TEST O PRODUCCION
	public static final boolean TEST_ASINCRONO_LOCAL = true;

	public static final Long TIPO_SERVICIO_UNIDAD_DESEMPENO = new Long(9);
	public static final Long TIPO_SERVICIO_DEPENDECIA = new Long(6);

	// Codigo Calidad Suplencia
	public static final String CODIGO_CALIDAD_SUPLENCIA = "3";

	/**
	 * Estados Volcados
	 */
	public static final String ESTADO_VOLCADO_OK = "OK";
	public static final String ESTADO_VOLCADO_FALLO = "FALLO";
	public static final String ESTADO_VOLCADO_PROCESANDO = "PROCESANDO";
	public static final String ESTADO_VOLCADO_ENCOLADO = "ENCOLADO";
	public static final String ESTADO_VOLCADO_PROCESADO = "PROCESADO";

	/**
	 * Atributos HSM Externo
	 */
	public static final String HSM_EXT_ATTR_APPNAME = "app_name";
	public static final String HSM_EXT_ATTR_APPAGENCY = "app_agency";
	public static final String HSM_EXT_ATTR_APPENTITY = "app_entity";
	public static final String HSM_EXT_ATTR_APPTOKNKEY = "app_token_key";
	public static final String HSM_EXT_ATTR_APPSECRET = "app_secret";
	public static final String HSM_EXT_ATTR_PAYPURPOSE = "payload_purpose";
	public static final String HSM_EXT_ATTR_APIBASEURI = "api_basepath_uri";
	public static final String HSM_EXT_ATTR_APIFIRSURI = "api_firstcall_uri";
	public static final String HSM_EXT_ATTR_APISECOURI = "api_secondcall_uri";
	public static final String HSM_EXT_ATTR_SIGCONTPAT = "sign_content_path";
	public static final String HSM_EXT_ATTR_MDALGORITH = "md_algorithm";
	public static final String HSM_EXT_ATTR_ONLYCALL = "api_only_call";
	public static final String HSM_KEYSTORE_DIR = "keystore_dir";
	public static final String HSM_KEYSTORE_PASS = "keystore_pass";

	// Codigos lista contrata
	public static final String COD_LISTA_CONTRATA = "CONTRATA";
	public static final String COD_LISTA_PRORROGAS_CONTRATA = "PROCONTR";
	public static final String COD_LISTA_CONTRATA_CON_FUNCIONES_DIRECTIVAS = "DIRECONTR";
	public static final String COD_LISTA_CONTRATO_HONORARIOS_ASIMILABLE_GRADO = "HONOGRAD";
	public static final String COD_LISTA_CONTRATO_HONORARIOS_SUMA_ALZADA = "HONOALZ";
	public static final String COD_LISTA_CONTADOR_AGENTE_PUBLICO = "AGENTE";
	public static final String COD_LISTA_CONTADOR_CARGOS_1608_INC_1 = "INCISO1";
	public static final String COD_LISTA_CONTADOR_CARGOS_1608_INC_2 = "INCISO2";
	public static final String COD_LISTA_CONTADOR_CARGOS_1608_INC_3 = "INCISO3";
	public static final String COD_LISTA_CONTADOR_CARGOS_1608_INC_3_INTERIOR = "INCISO3INT";
	public static final String COD_LISTA_CONTRATADOS_MODALIDAD_CODIGO_TRABAJO = "CODIGO";
	public static final String COD_LISTA_VIGILANTES_PRIVADOS = "VIGILANTE";
	public static final String COD_LISTA_NOCHEROS_GUARDIAS = "NOCHER";

	// Codigos materias SIAPER TRL para CONTRATACIONES
	public static final String COD_MATERIA_CONTRATA_1608_EXENTA = "contrata_1608_exenta";
	public static final String COD_MATERIA_CONTRATA_1608 = "contrata_1608";
	public static final String COD_MATERIA_DESIGNACION_CONTRATA_1608_EXENTA = "desig_cont_1608_EX";
	public static final String COD_MATERIA_DESIGNACION_CONTRATA_1608 = "desig_contrata_1608";
	public static final String COD_MATERIA_CONTRATA_1608_2019 = "contra_1608_2019";
	public static final String COD_MATERIA_CONTRATA_TRE_1608_2019 = "contra_tre_1608_2019";
	public static final String COD_MATERIA_CONTRATA_LEY_20948 = "contrata_ley_20948";
	public static final String COD_MATERIA_CONTRATA_LEY_20948_2019 = "contrat_le20948_2019";
	public static final String COD_MATERIA_CONTRATA_LEY_20948_TRE = "contrata_20948_tre";
	public static final String COD_MATERIA_CONTRATA_LEY_20948_2019_TRE = "cont_20948_tre_2019";
	public static final String COD_MATERIA_CONTRATA_EXENTA = "contrata_exenta";
	public static final String COD_MATERIA_CONTRATA_EXENTA_TRE = "contrata_exenta_tre";
	public static final String COD_MATERIA_CONTRATA_INFERIOR_6_MESES = "contr_univ_inferior";
	public static final String COD_MATERIA_CONTRATA_TRE = "contrata_tre";
	public static final String COD_MATERIA_CONTRATA_SUPERIOR_6_MESES = "contr_univer_sup";
	public static final String COD_MATERIA_CONTRATA_SUPERIOR_3_MESES = "desig_contr_ok_2";
	public static final String COD_MATERIA_CONTRATA_TRE_2019 = "contrata_tre_2019";
	public static final String COD_MATERIA_PRORROGA_CONTRATA = "pror_contrata_ok";
	public static final String COD_MATERIA_PRORROGA_CONTRATA_TRE = "porr_contrata_tre";
	public static final String COD_MATERIA_CONTRATA_INDEFINIDA_2019 = "contrata_indef_2019";
	public static final String COD_MATERIA_CONTRATA_SLE_2019 = "contrata_sle_2019";
	public static final String COD_MATERIA_DESIGNACION_CONTRATA_OK = "desig_contr_ok";
	public static final String COD_MATERIA_DESIGNACION_CONTRATA_2019 = "desig_contrata_2019";

	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_SUPERIOR_250_CC_TRE = "hono_sum_comp_tre";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_SUPERIOR_250_TRE = "hono_sum_tre";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_SUPERIOR_CC_TRE = "hon_cta_com_tre_2019";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_TRE = "hono_alza_universida";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_TRE_2019 = "hono_suma_tre_2019";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_SUPERIOR_TRE_CC = "hono_cta_comp_univer";
	public static final String COD_CONTRATO_HONORARIO_ASIMILADO_PRACTICA = "egresados_hono_grado";
	public static final String COD_CONTRATO_HONORARIO_ASIMILADO_GRADO_TRE = "hono_grado_tre";
	public static final String COD_CONTRATO_HONORARIO_ASIMILADO_GRADO_TRE_2019 = "hono_grado_tre_2019";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_PERSONA_NATURAL = "honorarios_suma_2019";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_PERSONA_NATURAL_CC = "hon_cta_comp_2019";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_PERSONA_NATURAL_SUPERIOR_250 = "hono_suma_ok";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_PERSONA_NATURAL_SUPERIOR_250_CC = "honorarios_fndr";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_CNA = "honorario_cna_2019";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_CNA_INFERIOR_250 = "honorario_CNA_exenta";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_CNA_SUPERIOR_250 = "honorario_CNA";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_INFERIOR_250 = "hono_suma_inf_200_ok";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_INFERIOR_250_CC = "hon_sum_inf_75_cta";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_INFERIOR_250_CC_TRE = "hono_cta_inf_250_tre";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_INFERIOR_250_TRE = "hono_250utm_ex_tre";
	public static final String COD_CONTRATO_HONORARIO_PERSONA_NATURAL_ASIMILADO_GRADO = "hono_grad_ok";
	public static final String COD_CONTRATO_HONORARIO_PERSONA_NATURAL_ASIMILADO_GRADO_2019 = "honor_grado_2019";
	public static final String COD_CONTRATO_HONORARIO_SUMA_ALZADA_TOTAL_SUPERIOR_250_CC_TRE = "hono_sum_comp_tre";

	// Codigos servicios especificos contrata
	public static final String COD_SERVICIO_ENCOMENDACION_FUNCIONES_DIRECTIVAS = "enco_funciones";

	/*
	 * Variables Retiro Documento
	 */
	public static final long TAMANIO_MAX_RETIRO_DOCUMENTO = 10485760; // 10 megabyte

	/**
	 * Manejo de archivo content manager.
	 */

	public static final String VAR_CONFIG = "extension";
	public static final String VAR_DOCS = "fecha";

	public static final String ODT = "odt";

	public static final String PKG = "pkg";

	public static final String DRL = "drl";

	public static final String XSD = "xsd";

	public static final String XML = "xml";

	public static final String IMG = "img";

	/**
	 * Componente generación PDF
	 */
	public static final String COMPONENTE_PDF_OPENOFFICE = "0";
	public static final String COMPONENTE_PDF_XDOCREPORT = "1";
	public static final String COMPONENTE_PDF_XDOCREPORT_2 = "2";

	/**
	 * Numeracion de oficios
	 */
	public static final String NUMERACION_OFICIO_ACTIVO = "activo";
	public static final String NUMERACION_OFICIO_PATH_BASE = "basePath";
	public static final String NUMERACION_OFICIO_PATH_API = "path_API";
	public static final String NUMERACION_OFICIO_METHOD_1 = "method_1";
	public static final String NUMERACION_OFICIO_METHOD_2 = "method_2";
	public static final String NUMERACION_OFICIO_API_KEY = "api_key";
	public static final String NUMERACION_OFICIO_API_SECRET = "api_secret";
	public static final String NUMERACION_OFICIO_KEYSTORE_DIR = "keystoreDir";
	public static final String NUMERACION_OFICIO_KEYSTORE_PASS = "keystorePass";
	public static final String NUMERACION_OFICIO_TIPO_DOCUMENTO = "tipoDocumento";
	public static final String NUMERACION_OFICIO_PREFIJO = "prefijo";
	public static final String NUMERACION_OFICIO_PREFIJO_PRUEBA = "prefijoPrueba";
	public static final String NUMERACION_OFICIO_SISTEMA = "sistema";
	public static final String NUMERACION_OFICIO_CANAL = "canal";
	public static final String NUMERACION_OFICIO_COD_CANAL = "30";
	public static final String NUMERACION_OFICIO_SERVICIO_PRUEBA = "9001";
	public static final String NUMERACION_OFICIO_SERVICIOS_PRUEBA = "servicioPrueba";

// Nueva implementación de envíos masivos (unificados)
    // Envío a Contraloría
    public static final String ESTADO_ENVIADO_CONTRALORIA = "INGRESADOCGR";
    public static final String ENVIA_A_CONTRALORIA = "ENVIA_A_CONTRALORIA";

    // Envío a Firmante (pendiente de firma)
    public static final String ENVIA_A_FIRMANTE = "ENVIOFIRM";
    public static final String ESTADO_ENVIADO_FIRMANTE = "PEFIR";

    // Devolución al Servicio Emisor
    public static final String DEVOLVER_SERVICIO_EMISOR = "DEVOTRS"; // acción real
    public static final String ESTADO_DEVUELTO_SERV_EMISOR = "DEVEMI"; // estado existente

    //Envio a otro servicio
    public static final String ESTADO_ENVIADO_OTRO_SERVICIO = "FIRMADO"; // mantiene estado actual
    public static final String DOCUMENTO_ENVIADO_OTRO_SERV = "ENVOTS";   // acción real existente en BD


}