package org.eclipse.scout.apps.scoretable.client.game;

import org.eclipse.scout.apps.scoretable.client.game.GamesOverviewTablePage.Table;
import org.eclipse.scout.apps.scoretable.shared.GamesOverviewTablePageData;
import org.eclipse.scout.apps.scoretable.shared.IGamesOverviewService;
import org.eclipse.scout.rt.client.dto.Data;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TreeMenuType;
import org.eclipse.scout.rt.platform.util.CollectionUtility;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractIntegerColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

import java.util.Set;

@Data(GamesOverviewTablePageData.class)
public class GamesOverviewTablePage extends AbstractPageWithTable<Table> {
    @Override
    protected boolean getConfiguredLeaf() {
        return true;
    }

    @Override
    protected void execLoadData(SearchFilter filter) {
        importPageData(BEANS.get(IGamesOverviewService.class).getGamesOverviewTableData(filter));
    }

    @Override
    protected String getConfiguredTitle() {
        return TEXTS.get("GamesOverviewTablePage");
    }

    public class Table extends AbstractTable {
      public NameColumn getNameColumn() {
        return getColumnSet().getColumnByClass(NameColumn.class);
      }

      public PlayersColumn getPlayersColumn() {
        return getColumnSet().getColumnByClass(PlayersColumn.class);
      }

      public StatusColumn getStatusColumn() {
        return getColumnSet().getColumnByClass(StatusColumn.class);
      }

      @Order(1000)
      public class NameColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Gamename");
        }

        @Override
        protected int getConfiguredWidth() {
          return 400;
        }
      }

      @Order(1500)
      public class PlayersColumn extends AbstractIntegerColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Players");
        }

        @Override
        protected int getConfiguredWidth() {
          return 70;
        }
      }

      @Order(2000)
      public class StatusColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Status");
        }

        @Override
        protected int getConfiguredWidth() {
          return 100;
        }
      }
    }

  @Order(1000)
  public class newGameMenu extends AbstractMenu {
    @Override
    protected String getConfiguredText() {
      return TEXTS.get("newGame");
    }

    @Override
    protected Set<? extends IMenuType> getConfiguredMenuTypes() {
      return CollectionUtility.hashSet(TreeMenuType.SingleSelection, TreeMenuType.MultiSelection);
    }

    @Override
    protected void execAction() {

    }
  }

  @Order(2000)
  public class editGameMenu extends AbstractMenu {
    @Override
    protected String getConfiguredText() {
      return TEXTS.get("viewGame");
    }

    @Override
    protected Set<? extends IMenuType> getConfiguredMenuTypes() {
      return CollectionUtility.hashSet(TreeMenuType.SingleSelection, TreeMenuType.MultiSelection);
    }

    @Override
    protected void execAction() {
      GameOverviewForm form = new GameOverviewForm();
      form.setName(getTable().getNameColumn().getSelectedValue());
      form.start();
      form.waitFor();
    }
  }

}
