/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.mundo;

import java.time.Year;

/**
 * Clase que representa un vino almacenado en la Cupi-Cava.<br>
 * <b>inv: </b> <br>
 * TODO Parte1 PuntoA: Declare la invariante de la clase.
 */
public class Vino
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa la presentación barril.
     */
    public final static String BARRIL = "Barril";

    /**
     * Constante que representa la presentación botella.
     */
    public final static String BOTELLA = "Botella";

    /**
     * Constante que representa el color tinto.
     */
    public final static String TINTO = "Tinto";

    /**
     * Constante que representa el color rosado.
     */
    public final static String ROSADO = "Rosado";

    /**
     * Constante que representa el color blanco.
     */
    public final static String BLANCO = "Blanco";

    /**
     * Constante que representa el tipo de vino seco.
     */
    public final static String SECO = "Seco";

    /**
     * Constante que representa el tipo de vino abocado.
     */
    public static final String ABOCADO = "Abocado";

    /**
     * Constante que representa el tipo de vino semi-seco.
     */
    public static final String SEMI_SECO = "Semi-seco";

    /**
     * Constante que representa el tipo de vino semi-dulce.
     */
    public static final String SEMI_DULCE = "Semi-dulce";

    /**
     * Constante que representa el tipo de vino dulce.
     */
    public static final String DULCE = "Dulce";

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Nombre del vino.
     */
    private String nombre;

    /**
     * Presentación del vino.
     */
    private String presentacion;

    /**
     * Año de elaboración del vino.
     */
    private int anhoElaboracion;

    /**
     * Contenido en azúcar del vino (gramos/litro).
     */
    private double contenidoAzucar;

    /**
     * Tipo del vino.
     */
    private String tipo;

    /**
     * Color del vino.
     */
    private String color;

    /**
     * Lugar de origen del vino.
     */
    private String lugarOrigen;

    /**
     * Ruta donde se encuentra la imagen del vino.
     */
    private String imagen;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Inicializa el vino con la información dada por parámetro. <br>
     * <b>post: </b> El vino se inicializó con los valores de nombre, presentación, año elaboración, contenido en azúcar, tipo, color, lugar de origen e imagen dados por
     * parámetro.
     * @param pNombre Nombre del vino. pNombre != null && pNombre != "".
     * @param pPresentacion Presentación del vino. pPresentacion != null && pPresentacion != "" && (pPresentacion == BOTELLA || pPresentacion == BARRIL).
     * @param pAnhoElaboracion Año de elaboración del vino. pAnhoElaboracion > 0.
     * @param pContenidoAzucar Contenido en azúcar del vino. pContenidoAzucar >= 0
     * @param pTipo Tipo de vino de acuerdo a su contenido en azúcar. pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @param pColor Color del vino. pColor != null && pColor != "" && (pColor == TINTO || pColor == ROSADO || pColor == BLANCO).
     * @param pLugarOrigen Lugar de origen del vino. lugarElaboracion != null y lugarElaboracion != "".
     * @param pImagen Imagen del vino. pImagen != null && pImagen != "".
     */
    public Vino( String pNombre, String pPresentacion, int pAnhoElaboracion, double pContenidoAzucar, String pTipo, String pColor, String pLugarOrigen, String pImagen )
    {
        nombre = pNombre;
        presentacion = pPresentacion;
        anhoElaboracion = pAnhoElaboracion;
        contenidoAzucar = pContenidoAzucar;
        tipo = calcularTipoVino(pContenidoAzucar);
        color = pColor;
        lugarOrigen = pLugarOrigen;
        imagen = pImagen;
        
        //Después de inicializar todos los atributos, se verifica la invariante.
        verificarInvariente();

    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna el nombre del vino.
     * @return Nombre del vino.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la presentación del vino.
     * @return Presentación del vino.
     */
    public String darPresentacion( )
    {
        return presentacion;
    }

    /**
     * Retorna el año de elaboración del vino.
     * @return Año de elaboración del vino.
     */
    public int darAnhoElaboracion( )
    {
        return anhoElaboracion;
    }

    /**
     * Retorna el contenido en azúcar del vino.
     * @return Contenido en azúcar del vino.
     */
    public double darContenidoAzucar( )
    {
        return contenidoAzucar;
    }

    /**
     * Retorna el tipo del vino.
     * @return Tipo del vino.
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna el color del vino.
     * @return Color del vino.
     */
    public String darColor( )
    {
        return color;
    }

    /**
     * Retorna el lugar de origen del vino.
     * @return Lugar de origen del vino.
     */
    public String darLugarOrigen( )
    {
        return lugarOrigen;
    }

    /**
     * Retorna la imagen del vino.
     * @return Imagen del vino.
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Compara dos vinos según el nombre. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo nombre. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el nombre. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el nombre. <br>
     */
    public int compararPorNombre( Vino pVino )
    {
    	 // TODO Parte2 PuntoA: Implemente el método según la documentación dada.
    }

    /**
     * Compara dos vinos según la presentación. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen la misma presentación. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para la presentación. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para la presentación. <br>
     */
    public int compararPorPresentacion( Vino pVino )
    {
   	 // TODO Parte2 PuntoB: Implemente el método según la documentación dada.
   }

    /**
     * Compara dos vinos según el año de elaboración. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo año de elaboración. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el año de elaboración. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el año de elaboración. <br>
     */
    public int compararPorAnhoElaboracion( Vino pVino )
    {
   	 // TODO Parte2 PuntoC: Implemente el método según la documentación dada.
   }

    /**
     * Compara dos vinos según el contenido en azúcar. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo contenido en azúcar. <br>
     *         Retorna -1 si el vino pVino tiene un mayor contenido en azúcar. <br>
     *         Retorna 1 si el vino pVino tiene un menor contenido en azúcar. <br>
     */
    public int compararPorContenidoAzucar( Vino pVino )
    {
   	 // TODO Parte2 PuntoD: Implemente el método según la documentación dada.
   }

    /**
     * Compara dos vinos según el tipo de vino. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo tipo. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el tipo. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el tipo. <br>
     */
    public int compararPorTipo( Vino pVino )
    {
   	 // TODO Parte2 PuntoE: Implemente el método según la documentación dada.
   }

    /**
     * Compara dos vinos según el color. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo color. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el color. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el color. <br>
     */
    public int compararPorColor( Vino pVino )
    {
   	 // TODO Parte2 PuntoF: Implemente el método según la documentación dada.
    }

    /**
     * Compara dos vinos según el lugar de origen. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo lugar de origen. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el lugar de origen. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el lugar de origen. <br>
     */
    public int compararPorLugarOrigen( Vino pVino )
    {
   	 // TODO Parte2 PuntoG: Implemente el método según la documentación dada.
   }

    /**
     * Retorna una cadena con el nombre del vino.
     * @return Representación del vino en una cadena de caracteres.
     */
    public String toString( )
    {
        return nombre;
    }
    
    //Metodos auxiliares para la invariante
    //-----------------------------------------------------------------
    

    /**
     * Método auxiliar para calcular el tipo de vino basado en su contenido de azúcar.
     * Este método es crucial para el constructor y la verificación de la invariante.
     * @param azucar Contenido de azúcar del vino en g/l.
     * @return El tipo de vino (SECO, ABOCADO, SEMI_SECO, SEMI_DULCE, DULCE) según los rangos.
     */
    private String calcularTipoVino(double azucar) {
    	if (azucar >= 0 && azucar < 5) {
    		return SECO;
    	}else if (azucar >= 5 && azucar < 15) {
    		return ABOCADO;
    	}else if (azucar >= 15 && azucar < 30) {
    		return SEMI_SECO;
    	}else if (azucar >= 30 && azucar < 50) {
    		return SEMI_DULCE;
    	}else if (azucar >= 50) {
    		return DULCE;
    	}else {
    		return "TIPO_DESCONOCIDO";//se asegura que siempre retorne un tipo valido
    	}
    	
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    // TODO Parte1 PuntoB: Documente e implemente el método verificarInvariante. Si lo desea puede crear métodos privados en esta parte.
    /**
     * Verifica la invariante de la clase.
     * Lanza una AssertionError si alguna de las condiciones de la invariante no se cumple.
     */
    public void verificarInvariente() {
    	//El nombre del vino no puede ser nulo ni vacio.
    	assert nombre != null && !nombre.trim().isEmpty() : "Invariante incorrecta: el nombre del vino no puede ser nulo o vacio.";
    	
    	//La presentación debe ser BARRIL o BOTELLA.
    	assert presentacion.equals(BARRIL) || presentacion.equals(BOTELLA) : "Invariante incorrecta: la presentacion debe ser barril o botella.";
    	
    	//El año de elaboración debe ser un valor positivo y no puede ser un año futuro.
        // Usamos Year.now().getValue() para obtener el año actual.
    	assert contenidoAzucar >= 0 && anhoElaboracion <= Year.now().getValue() + 1 : "Invariante incorrecta: el año de elaboracion no es valido.";
    	
    	//El contenido de azúcar debe ser mayor o igual a cero.
    	assert contenidoAzucar >= 0 : "Invariante incorrecta: el contenido de azucar no puede ser negativo 0 cero.";
    	
    	//El color debe ser TINTO, ROSADO o BLANCO.
    	assert color.equals(TINTO) || color.equals(ROSADO) || color.equals(BLANCO) : "Invariante incorrecta: el color debe ser TINTO, ROSADO o BLANCO.";
    	
    	//El lugar de origen no puede ser nulo ni vacío.
    	assert lugarOrigen != null && !lugarOrigen.trim().isEmpty() : "Invariante incorrecta: el lugar de origen no puede ser nulo o vacío.";
    	
    	//La imagen (su ruta) no puede ser nula ni vacía.
    	assert imagen != null && !imagen.trim().isEmpty() : "Invariante incorrecta: la imagen no puede ser nula o vacía.";
    	
    	//El tipo de vino debe corresponder exactamente al contenido de azúcar.
    	 assert tipo.equals(calcularTipoVino(contenidoAzucar)) : "Invariante incorrecta: el tipo de vino no corresponde al contenido de azúcar.";
    }
}