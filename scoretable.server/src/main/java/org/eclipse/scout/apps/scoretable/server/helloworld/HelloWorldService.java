package org.eclipse.scout.apps.scoretable.server.helloworld;

import org.eclipse.scout.apps.scoretable.server.ServerSession;
import org.eclipse.scout.apps.scoretable.shared.helloworld.HelloWorldFormData;
import org.eclipse.scout.apps.scoretable.shared.helloworld.IHelloWorldService;

/**
 * @author noeba
 */
public class HelloWorldService implements IHelloWorldService {

  @Override
  public HelloWorldFormData load(HelloWorldFormData input) {
    StringBuilder msg = new StringBuilder();
    msg.append("Hello ").append(ServerSession.get().getUserId()).append('!');
    input.getMessage().setValue(msg.toString());
    return input;
  }
}
