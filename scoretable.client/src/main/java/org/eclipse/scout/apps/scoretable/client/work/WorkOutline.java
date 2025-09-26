package org.eclipse.scout.apps.scoretable.client.work;

import java.util.List;

import org.eclipse.scout.apps.scoretable.client.game.GamesOverviewTablePage;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.text.TEXTS;

import org.eclipse.scout.apps.scoretable.shared.Icons;

/**
 * @author noeba
 */
@Order(1000)
public class WorkOutline extends AbstractOutline {

  @Override
  protected void execCreateChildPages(List<IPage<?>> pageList) {
    super.execCreateChildPages(pageList);
    pageList.add(new GamesOverviewTablePage());
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("yourgames");
  }

  @Override
  protected String getConfiguredIconId() {
    return Icons.File;
  }
}
