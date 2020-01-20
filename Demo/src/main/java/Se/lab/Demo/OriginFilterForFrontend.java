package Se.lab.Demo;

import java.net.MalformedURLException;
import java.net.URL;

import com.google.common.collect.Lists;

import lombok.Delegate;
import lombok.NonNull;
import lombok.SneakyThrows;

public class OriginFilterForFrontend implements OriginFilter {

  @Delegate
  private final OriginFilter.Default defaultOriginFilter;

  @SneakyThrows(MalformedURLException.class)
  public OriginFilterForFrontend(@NonNull String frontendDomain) throws MalformedURLException {
      defaultOriginFilter = new OriginFilter.Default(Lists.newArrayList(new URL("https://www."
              + frontendDomain), new URL("https://" + frontendDomain)), Lists.newArrayList(
                      "localhost", "0.0.0.0", "127.0.0.1"));
  }


}