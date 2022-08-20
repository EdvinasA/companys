package com.data.company.utils;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import lombok.experimental.UtilityClass;
import org.slf4j.MDC;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;
import reactor.core.publisher.SignalType;
import reactor.core.scheduler.Schedulers;
import reactor.util.context.Context;

@UtilityClass
public class ReactiveUtils {

	private static final String CONTEXT_MAP = "context-map";

	public static Function<Context, Context> put(Map<String, String> mdcContextMap) {
		return context -> {
			Optional<Map<String, String>> optionalContextMap = context.getOrEmpty(CONTEXT_MAP);

			if (optionalContextMap.isPresent()) {
				optionalContextMap.get().putAll(mdcContextMap);
				return context;
			}
			if (Objects.nonNull(mdcContextMap)) {
				return context.put(CONTEXT_MAP, mdcContextMap);
			}

			return context;
		};
	}

	public static <T> Consumer<Signal<T>> consumeOnNext(Consumer<T> consumer) {
		return signal -> {
			if (signal.getType() != SignalType.ON_NEXT) {
				return;
			}

			Optional<Map<String, String>> optionalContextMap = signal.getContextView()
					.getOrEmpty(CONTEXT_MAP);

			if (optionalContextMap.isEmpty()) {
				consumer.accept(signal.get());
			} else {
				MDC.setContextMap(optionalContextMap.get());

				try {
					consumer.accept(signal.get());
				} finally {
					MDC.clear();
				}
			}
		};
	}

	public static <T> Consumer<Signal<T>> consumeOnError(Consumer<Throwable> consumer) {
		return signal -> {
			if (!signal.isOnError()) {
				return;
			}

			Optional<Map<String, String>> optionalContextMap = signal.getContextView()
					.getOrEmpty(CONTEXT_MAP);

			if (optionalContextMap.isEmpty()) {
				consumer.accept(signal.getThrowable());
			} else {
				MDC.setContextMap(optionalContextMap.get());

				try {
					consumer.accept(signal.getThrowable());
				} finally {
					MDC.clear();
				}
			}
		};
	}

	public static void registerScheduleHook() {
		Schedulers.onScheduleHook("mdc", runnable -> {
			Map<String, String> mdcContextMap = MDC.getCopyOfContextMap();

			return () -> {
				if (Objects.nonNull(mdcContextMap)) {
					MDC.setContextMap(mdcContextMap);
				}
				try {
					runnable.run();

				} finally {}
			};
		});
	}

	public static <T> Function<? super Throwable, ? extends Mono<? extends T>> withMdcContext(
			Map<String, String> mdcContextMap,
			Function<? super Throwable, ? extends Mono<? extends T>> function) {
		return arg -> {
			if (Objects.nonNull(mdcContextMap)) {
				MDC.setContextMap(mdcContextMap);
			}

			return function.apply(arg);
		};
	}
}
