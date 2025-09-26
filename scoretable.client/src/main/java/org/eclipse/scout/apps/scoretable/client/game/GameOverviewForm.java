package org.eclipse.scout.apps.scoretable.client.game;

import org.eclipse.scout.apps.scoretable.client.game.GameOverviewForm.MainBox.CancelButton;
import org.eclipse.scout.apps.scoretable.client.game.GameOverviewForm.MainBox.GroupBox;
import org.eclipse.scout.apps.scoretable.client.game.GameOverviewForm.MainBox.OkButton;
import org.eclipse.scout.apps.scoretable.shared.game.CreateGameOverviewPermission;
import org.eclipse.scout.apps.scoretable.shared.game.GameOverviewFormData;
import org.eclipse.scout.apps.scoretable.shared.game.IGameOverviewService;
import org.eclipse.scout.apps.scoretable.shared.game.UpdateGameOverviewPermission;
import org.eclipse.scout.rt.client.dto.FormData;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.text.TEXTS;

@FormData(value = GameOverviewFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class GameOverviewForm extends AbstractForm {
    @Override
    protected String getConfiguredTitle() {
        return TEXTS.get("GameOverview");
    }

  @Override
  protected int getConfiguredDisplayHint() {
    return DISPLAY_HINT_VIEW;
  }

  public MainBox getMainBox() {
        return getFieldByClass(MainBox.class);
    }

    public GroupBox getGroupBox() {
        return getFieldByClass(GroupBox.class);
    }

    public OkButton getOkButton() {
        return getFieldByClass(OkButton.class);
    }

    public CancelButton getCancelButton() {
        return getFieldByClass(CancelButton.class);
    }

    @Order(1000)
    public class MainBox extends AbstractGroupBox {
        @Order(1000)
        public class GroupBox extends AbstractGroupBox {

        }

        @Order(2000)
        public class OkButton extends AbstractOkButton {
        }

        @Order(3000)
        public class CancelButton extends AbstractCancelButton {
          @Override
          protected boolean getConfiguredVisible() {
            return false;
          }
        }
    }

    public void startModify() {
        startInternalExclusive(new ModifyHandler());
    }

    public void startNew() {
        startInternal(new NewHandler());
    }

    public class NewHandler extends AbstractFormHandler {
        @Override
        protected void execLoad() {
            GameOverviewFormData formData = new GameOverviewFormData();
            exportFormData(formData);
            formData = BEANS.get(IGameOverviewService.class).prepareCreate(formData);
            importFormData(formData);

            setEnabledPermission(new CreateGameOverviewPermission());
        }

        @Override
        protected void execStore() {
            GameOverviewFormData formData = new GameOverviewFormData();
            exportFormData(formData);
            formData = BEANS.get(IGameOverviewService.class).create(formData);
            importFormData(formData);
        }
    }

    public class ModifyHandler extends AbstractFormHandler {
        @Override
        protected void execLoad() {
            GameOverviewFormData formData = new GameOverviewFormData();
            exportFormData(formData);
            formData = BEANS.get(IGameOverviewService.class).load(formData);
            importFormData(formData);

            setEnabledPermission(new UpdateGameOverviewPermission());
        }

        @Override
        protected void execStore() {
            GameOverviewFormData formData = new GameOverviewFormData();
            exportFormData(formData);
            formData = BEANS.get(IGameOverviewService.class).store(formData);
            importFormData(formData);
        }
    }
}
