package com.example.versiones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.versiones.Adaptadores.AdaptadorVersiones;
import com.example.versiones.Utils.Version;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements AdaptadorVersiones.OnVersionListener {
    RecyclerView recycler;
    AdaptadorVersiones adaptador;
    ArrayList<Version> versiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();

        configurarRecycler();
    }

    private void rellenarLista() {
        versiones.add(new Version(R.drawable.apple_det, "Apple Pie", "Android 1.0, la primera versión comercial del software, fue lanzado el 23 septiembre de 2008. El primer dispositivo Android, el HTC Dream, incorporó las siguientes características de Android 1.0: ", "23 de septiembre de 2008", "1.0"));
        versiones.add(new Version(R.drawable.banana_det, "Banana Bread", "El 9 de febrero de 2009, La actualización Android 1.1 fue lanzada, inicialmente sólo para el HTC Dream. Android 1.1 fue conocido como \"Banana Bread\" internamente, aunque este nombre no se utilizó oficialmente. La actualización resolvió fallos, cambió la API y agregó una serie de características", "9 de febrero de 2009", "1.1"));
        versiones.add(new Version(R.drawable.cupcake_det, "Cupcake", "Android 1.5 Cupcake fue la segunda versión de Android desarrollada por Google, un lanzamiento mayor de la plataforma para los teléfonos inteligentes con Android, empezando en mayo de 2009. Este lanzamiento incluyó nuevas funciones para ambos desarrolladores y usuarios, así como también en el esqueleto del API de Android . Para los desarrolladores, la plataforma 1.5 de Android fue disponible como un componente descargable del Android SDK", "25 de abril de 2009", "1.5"));
        versiones.add(new Version(R.drawable.donut_det, "Donut", "El 15 de septiembre de 2009, fue lanzado el SDK de Android 1.6 Donut, basado en el núcleo Linux 2.6.29. En la actualización se incluyen numerosas características nuevas", "15 de septiembre de 2009", "1.6"));
        versiones.add(new Version(R.drawable.eclair_det, "Eclair", "El 26 de octubre de 2009, el SDK de Android 2.0 – con nombre en clave Eclair – fue lanzado, basado en el núcleo de linux 2.6.29", "26 de octubre de 2009", "2.0 - 2.1"));
        versiones.add(new Version(R.drawable.froyo_det, "Froyo", "El 20 de mayo de 2010, El SDK de Android 2.2 Froyo (Yogur helado) fue lanzado, basado en el núcleo Linux 2.6.32", "20 de mayo de 2010", "2.2 - 2.2.3"));
        versiones.add(new Version(R.drawable.gige_det, "Gingerbread", "El 6 de diciembre de 2010, el SDK de Android 2.3 Gingerbread (Pan de Jengibre) fue lanzado, basado en el núcleo Linux 2.6.35.", "6 de diciembre de 2010", "2.3 - 2.3.7"));
        versiones.add(new Version(R.drawable.honey_det, "Honeycomb", "El 22 de febrero de 2011, sale el SDK de Android 3.0 Honeycomb (Panal de Miel). Fue la primera actualización exclusiva para TV y tableta, lo que quiere decir que sólo es apta para TV y tabletas y no para teléfonos Android. Está basada en el núcleo de Linux 2.6.36. El primer dispositivo con esta versión fue la tableta Motorola Xoom, lanzado el 24 de febrero de 2011.", "22 de febrero de 2011", "3.0 - 3.2.6"));
        versiones.add(new Version(R.drawable.ice_det, "Ice Cream Sandwich", "El SDK para Android 4.0.0 Ice Cream Sandwich (Sandwich de Helado), basado en el núcleo de Linux 3.0.1, fue lanzado públicamente el 12 de octubre de 2011. Gabe Cohen de Google declaró que Android 4.0 era \"teóricamente compatible\" con cualquier dispositivo Android 2.3 en producción en ese momento, pero sólo si su procesador y memoria ram lo soportaban. El código fuente para Android 4.0 se puso a disposición el 14 de noviembre de 2011", "18 de octubre de 2011", "4.0 - 4.0.5"));
        versiones.add(new Version(R.drawable.jelly_det, "Jelly Bean", "Google anunció Android 4.1 Jelly Bean (Gomita Confitada o Gominola) en la conferencia del 30 de junio de 2012. Basado en el núcleo de linux 3.0.31, Bean fue una actualización incremental con el enfoque primario de mejorar la funcionalidad y el rendimiento de la interfaz de usuario. La mejora de rendimiento involucró el \"Proyecto Butter\", el cual usa anticipación táctil, triple buffer, latencia vsync extendida y un arreglo en la velocidad de cuadros de 60 fps para crear una fluida y \"mantecosa\" suavidad de la interfaz de usuario.ndroid 4.1 Jelly Bean fue lanzado bajo AOSP el 9 de julio de 2012, y el Nexus 7, el primer dispositivo en correr Jelly Bean, fue lanzado el 13 de julio de 2012", "9 de julio de 2012", "4.1 - 4.3.1"));
        versiones.add(new Version(R.drawable.kit_det, "KitKat", "Su nombre se debe a la chocolatina KitKat, de la empresa internacional Nestlé.", "31 de octubre de 2013", "4.4 - 4.4.4"));
        versiones.add(new Version(R.drawable.lolli_det, "Lollipop", "Android Lollipop es una versión del sistema operativo para dispositivos móviles Android. Fue dada a conocer el 25 de junio de 2014 durante el Google I/O 2014 como Android L y su versión fue liberada el día siguiente a determinados dispositivos Google Nexus, concretamente el Nexus 5 y la tableta Nexus 7 2013. El 15 de octubre de 2014, Google dio el nombre oficial de Android L: Lollipop (al español: piruleta, chupetín, chupeta o paletita) y la versión es 5.0, siendo anunciado oficialmente junto al Nexus 6, Nexus 9 y Nexus Player. Su versión en código AOSP se lanzó el 3 de noviembre junto a los Nexus 6 y Nexus 9 (primeros dispositivos en incluirlo).", "12 de noviembre de 2014", "5.0 - 5.1.1"));
        versiones.add(new Version(R.drawable.android_6_det, "Marshmallow", "Android Marshmallow o \"Malvavisco\" es una versión del sistema operativo para dispositivos móviles Android. Fue dada a conocer el 28 de mayo de 2015 en el evento Google I/O como Android M. Android Marshmallow, oficialmente presentado ya con esa nomenclatura el 17 de agosto de 2015, se centra principalmente en mejoras incrementales y nuevas características.", "5 de octubre de 2015", "6.0 - 6.0.1"));
        versiones.add(new Version(R.drawable.nougat, "Nougat", "Su nombre en español significa Turrón. Se libera la OTA el 22 de agosto de 2016 de momento para los Nexus 6, 5x, 6P, 9, Nexus Player, Pixel C y Android One.", "15 de junio de 2016", "7.0 - 7.1.2"));
        versiones.add(new Version(R.drawable.android8, "Oreo", "Android Oreo es el nombre de la antepenúltima versión del sistema operativo móvil Android que anunció la firma Google el día 21 de marzo de 2017. Su nombre fue revelado el 21 de agosto de 2017, el día del eclipse total de Sol en Estados Unidos. Se lanzó por primera vez como una versión previa para desarrolladores en fase alfa el 21 de marzo de 2017, para los móviles de Google (Nexus y Pixel). La segunda versión para desarrolladores se lanzó el 17 de mayo de 2017 y se considera en fase beta. La tercera versión para desarrolladores fue lanzada el 8 de junio de 2017 y contiene las API definitivas", "21 de agosto de 2017\t", "8.0 - 8.1"));
        versiones.add(new Version(R.drawable.android9, "Pie", "Se le conoce con el nombre de Pie (Tarta en inglés). Se caracteriza por sustituir los botones home, volver y multitarea por una barra de gestos, se puede poner un límite de uso de apps y mejoras en base al modo silenciar así como el rendimiento de batería", "6 de agosto de 2018", "9.0"));
        versiones.add(new Version(R.drawable.android10, "android 10", "Esta versión de Android incluirá un tema oscuro para todo el sistema. Algo que los usuarios de esta plataforma venían pidiendo hace tiempo. Tendrá un modo de activación que dependerá del usuario, lo que hará posible dejarlo activado siempre, desactivado o también activo dependiendo de una hora previamente configurada. Tanto el lanzador de aplicaciones, los ajustes y otras aplicaciones se pondrán en su modo oscuro. Por otra parte, se renovarán los permisos, de manera que se podrá conocer con estadísticas los permisos más usados por las aplicaciones y filtrar por tipo de permisos. Otra novedad es que Android 10 permitirá a las operadoras bloquear las SIM de sus competidores, de tal manera que se podrá bloquear la segunda ranura de los dispositivos con doble SIM. Esta restricción de bloqueo de la SIM se aplica de inmediato y se mantendrá aunque se reinicie el teléfono o se restablezca la configuración de fábrica. Estos cambios no afectaran en ningún momento a los móviles libres, es decir, que no estén enlazados a ninguna compañía. Otro punto importante es que Android incluirá su propio soporte nativo de reconocimiento facial siguiendo, de esta forma, las pautas de seguridad conocidas en los dispositivos Apple. Por último, en esta versión llegará un modo escritorio similar a Samsung DeX, en el que se podrá conectar el móvil a una pantalla secundaria y ver en el monitor una interfaz de escritorio tipo Windows.", "3 de septiembre de 2019", "10.0"));

    }

    private void instancias() {
        recycler = findViewById(R.id.recycler);
        versiones = new ArrayList();
        rellenarLista();
        adaptador = new AdaptadorVersiones(versiones, MainActivity.this);

    }
    private void configurarRecycler() {
        recycler.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();
        recycler.setLayoutManager(new GridLayoutManager(this,2, RecyclerView.VERTICAL, false));
    }

    @Override
    public void version(Version v) {
        Intent i = new Intent(getApplicationContext(), Second_Activity.class);
        i.putExtra("TAG1", v);
        startActivity(i);
    }
}
