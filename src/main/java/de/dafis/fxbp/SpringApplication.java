package de.dafis.fxbp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dlsc.workbenchfx.Workbench;
import com.dlsc.workbenchfx.view.controls.ToolbarItem;

import de.dafis.fxbp.tabone.TabOneView;
import de.dafis.fxbp.tabtwo.TabTwoView;
import javafx.application.Application;
import javafx.application.Platform;

/**
 * Eine eigenständige Starterklasse. Diese wird beötigt, um die JavaFX Applikation auch in einer nicht modularen Umgebung per Eclipse zu
 * starten.
 * <p>
 * Dadurch ist es möglich das Testsystem und den Debugger von Eclipse zu nutzen.
 * 
 * @author Peter Paul Kiefer
 */
@SpringBootApplication
public class SpringApplication
{
   public static void main( String[] args )
   {
      Application.launch( FxApp.class, args );
   }

   @Bean
   @Autowired
   public Workbench initWorkbench( TabOneView tabOneView, TabTwoView tabTwoView )
   {
      Workbench wb = Workbench.builder( //
         tabOneView, tabTwoView //
      ).build();

      wb.getToolbarControlsLeft().add( new ToolbarItem( "Workbench FX Boilerplate" ) );
      
      wb.getToolbarControlsRight().add( new ToolbarItem( "Über ..." ) );
      wb.getToolbarControlsRight().add( new ToolbarItem( "Hilfe" ) );
      wb.getToolbarControlsRight().add( new ToolbarItem( "Beenden", ev -> { 
         Platform.exit();
      } ) );

      wb.getStylesheets().add( SpringApplication.class.getResource( "/ect-theme.css" ).toExternalForm() );

      return wb;
   }
}