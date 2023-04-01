package bitxon.dropwizard;

import java.util.concurrent.Executors;

import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.dropwizard.core.server.DefaultServerFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JsonTypeName("virtual")
public class VirtualThreadServerFactory extends DefaultServerFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(VirtualThreadServerFactory.class);

    @Override
    protected ThreadPool createThreadPool(MetricRegistry metricRegistry) {
        var threadPool = super.createThreadPool(metricRegistry);
        if (threadPool instanceof QueuedThreadPool queuedThreadPool) {
            queuedThreadPool.setVirtualThreadsExecutor(Executors.newVirtualThreadPerTaskExecutor());
            LOGGER.info("Using VirtualThreadPerTaskExecutor for QueuedThreadPool");
            return queuedThreadPool;
        }

        throw new IllegalStateException("Unexpected ThreadPool type of " + threadPool.getClass().getName());
    }
}
