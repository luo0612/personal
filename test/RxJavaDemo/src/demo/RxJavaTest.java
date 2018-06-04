package demo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class RxJavaTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Observable.ambArray(Observable.just(1, 2, 3).delay(1, TimeUnit.SECONDS), Observable.just(5, 6))
				.subscribe(new Consumer<Integer>() {

					@Override
					public void accept(Integer arg0) throws Exception {
						System.out.println(arg0);
					}
				});

	}
}
