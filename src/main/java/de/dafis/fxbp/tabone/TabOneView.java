package de.dafis.fxbp.tabone;

import org.springframework.stereotype.Component;

import com.dlsc.workbenchfx.model.WorkbenchModule;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

@Component
public class TabOneView extends WorkbenchModule
{
   protected TabOneView()
   {
      super( "TAB 1", FontAwesomeIcon.GLOBE );
   }

   @Override
   public Node activate()
   {
      HBox mainPanel = new HBox(20);
      
      TabPane tabPane = new TabPane();
      tabPane.getTabs().add( createTab( "Sub TAB 1", new Label( "T1" ) ) );
      tabPane.getTabs().add( createTab( "Sub TAB 2", new Label( "T2" ) ) );
      tabPane.getTabs().add( createTab( "Sub TAB 3", new Label( "T3" ) ) );
      
      HBox.setHgrow( tabPane, Priority.ALWAYS );
      mainPanel.getChildren().add( tabPane );
      
      return mainPanel;
   }

   private Tab createTab( String title, Node content)
   {
      Tab tab = new Tab(title, content);
      tab.setClosable( false );
      return tab;
   }
}