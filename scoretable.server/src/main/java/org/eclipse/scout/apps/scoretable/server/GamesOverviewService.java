package org.eclipse.scout.apps.scoretable.server;

import org.eclipse.scout.apps.scoretable.shared.GamesOverviewTablePageData;
import org.eclipse.scout.apps.scoretable.shared.IGamesOverviewService;
import org.eclipse.scout.rt.server.jdbc.SQL;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class GamesOverviewService implements IGamesOverviewService {
    @Override
    public GamesOverviewTablePageData getGamesOverviewTableData(SearchFilter filter) {
        GamesOverviewTablePageData pageData = new GamesOverviewTablePageData();
      SQL.selectInto(
        "SELECT " +
          "  name, " +
          "  persons, " +
          "  status " +
          "FROM develop.game_table " +
          "ORDER BY name",
        pageData);
        return pageData;
    }
}
