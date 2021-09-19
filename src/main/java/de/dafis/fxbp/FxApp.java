package de.dafis.fxbp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.dlsc.workbenchfx.Workbench;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Diese Klasse enthält die Implementierung der Java FX Applikation (GUI).
 * <p>
 * Die Applikation besitzt drei Hauptfenster (Scenes):
 * 
 * <ul>
 * <li>Das Anmeldefenster: Wird zu Beginn gestartet um die Anmeldedaten einzugeben.</li>
 * <li>Die Workbench: Der Haupt-Arbeitsbereich der Benutzer.</li>
 * <li>Das Hilfefenster: Hier werden die Hilfeseiten und generelle Dokumentation angezeigt.</li>
 * </ul>
 * 
 * @author Peter Paul Kiefer
 */
public class FxApp extends Application
{
   private transient ConfigurableApplicationContext applicationContext;

   @Override
   public void init() throws Exception
   {
      String[] args = getParameters().getRaw().toArray( new String[ 0 ] );

      this.applicationContext = new SpringApplicationBuilder().//
         sources( SpringApplication.class ).//
         run( args );
   }

   @Override
   public void start( Stage primaryStage ) throws Exception
   {
      Workbench workbench = applicationContext.getBean( Workbench.class );
      Scene scene = new Scene( workbench );

      primaryStage.setScene( scene );
      primaryStage.show();
      primaryStage.setMaximized( true );
   }

   @Override
   public void stop() throws Exception
   {
      this.applicationContext.close();
   }
}