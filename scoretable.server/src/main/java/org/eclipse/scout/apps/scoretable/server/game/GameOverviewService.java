package org.eclipse.scout.apps.scoretable.server.game;

import org.eclipse.scout.apps.scoretable.shared.game.*;
import org.eclipse.scout.rt.platform.exception.VetoException;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.security.ACCESS;

public class GameOverviewService implements IGameOverviewService {
    @Override
    public GameOverviewFormData prepareCreate(GameOverviewFormData formData) {
        if (!ACCESS.check(new CreateGameOverviewPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
// TODO [noeba] add business logic here.
        return formData;
    }



    @Override
    public GameOverviewFormData create(GameOverviewFormData formData) {
        if (!ACCESS.check(new CreateGameOverviewPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
// TODO [noeba] add business logic here.
        return formData;
    }

    @Override
    public GameOverviewFormData load(GameOverviewFormData formData) {
        if (!ACCESS.check(new ReadGameOverviewPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
// TODO [noeba] add business logic here.
        return formData;
    }

    @Override
    public GameOverviewFormData store(GameOverviewFormData formData) {
        if (!ACCESS.check(new UpdateGameOverviewPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
// TODO [noeba] add business logic here.
        return formData;
    }
}
