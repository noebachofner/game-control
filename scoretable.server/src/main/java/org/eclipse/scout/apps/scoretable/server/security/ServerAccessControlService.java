package org.eclipse.scout.apps.scoretable.server.security;

import org.eclipse.scout.apps.scoretable.server.game.GameOverviewService;
import org.eclipse.scout.apps.scoretable.shared.game.CreateGameOverviewPermission;
import org.eclipse.scout.apps.scoretable.shared.game.ReadGameOverviewPermission;
import org.eclipse.scout.apps.scoretable.shared.game.UpdateGameOverviewPermission;
import org.eclipse.scout.apps.scoretable.shared.security.AccessControlService;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Replace;
import org.eclipse.scout.rt.security.AllPermissionCollection;
import org.eclipse.scout.rt.security.DefaultPermissionCollection;
import org.eclipse.scout.rt.security.IPermissionCollection;
import org.eclipse.scout.rt.security.PermissionLevel;
import org.eclipse.scout.rt.shared.security.RemoteServiceAccessPermission;

/**
 * @author noeba
 */
@Replace
public class ServerAccessControlService extends AccessControlService {

  @Override
  protected IPermissionCollection execLoadPermissions(String userId) {
    IPermissionCollection permissions = BEANS.get(DefaultPermissionCollection.class);
    permissions.add(new RemoteServiceAccessPermission("*.shared.*", "*"), PermissionLevel.ALL);
    permissions.add(new CreateGameOverviewPermission(), PermissionLevel.ALL);
    permissions.add(new ReadGameOverviewPermission(), PermissionLevel.ALL);
    permissions.add(new UpdateGameOverviewPermission(), PermissionLevel.ALL);
    BEANS.get(AllPermissionCollection.class);

    permissions.setReadOnly();
    return permissions;
  }
}
