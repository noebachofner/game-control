package org.eclipse.scout.apps.scoretable.shared.helloworld;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

import org.eclipse.scout.apps.scoretable.shared.helloworld.HelloWorldFormData;

/**
 * @author noeba
 */
@TunnelToServer
public interface IHelloWorldService extends IService {
      HelloWorldFormData load(HelloWorldFormData input);
}
