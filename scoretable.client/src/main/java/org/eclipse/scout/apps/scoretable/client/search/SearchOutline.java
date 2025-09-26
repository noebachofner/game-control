package org.eclipse.scout.apps.scoretable.client.search;

import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractSearchOutline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.eclipse.scout.apps.scoretable.shared.Icons;

/**
 * @author noeba
 */
@Order(2000)
public class SearchOutline extends AbstractSearchOutline {

  private static final Logger LOG = LoggerFactory.getLogger(SearchOutline.class);

  @Override
  protected void execSearch(final String query) {
    LOG.info("Search started");
    // TODO [noeba]: Implement search
  }

  @Override
  protected String getConfiguredIconId() {
    return Icons.Search;
  }
}
