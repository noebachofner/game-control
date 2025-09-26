package org.eclipse.scout.apps.scoretable.shared.game;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

@TunnelToServer
public interface IGameOverviewService extends IService {
    GameOverviewFormData prepareCreate(GameOverviewFormData formData);

    GameOverviewFormData create(GameOverviewFormData formData);

    GameOverviewFormData load(GameOverviewFormData formData);

    GameOverviewFormData store(GameOverviewFormData formData);
}
