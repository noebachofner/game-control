package org.eclipse.scout.apps.scoretable.shared;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

@TunnelToServer
public interface IGamesOverviewService extends IService {
    GamesOverviewTablePageData getGamesOverviewTableData(SearchFilter filter);
}
