package org.eclipse.scout.apps.scoretable.server;

import org.eclipse.scout.apps.scoretable.shared.GamesOverviewTablePageData;
import org.eclipse.scout.apps.scoretable.shared.IGamesOverviewService;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class GamesOverviewService implements IGamesOverviewService {
    @Override
    public GamesOverviewTablePageData getGamesOverviewTableData(SearchFilter filter) {
        GamesOverviewTablePageData pageData = new GamesOverviewTablePageData();
// TODO [noeba] fill pageData.
        return pageData;
    }
}
