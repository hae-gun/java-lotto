package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class LottoNumbers {
    private static final int LOTTO_NUMBER = 6;
    private static final int LOTTO_NUMBER_START_RANGE = 1;
    private static final int LOTTO_NUMBER_END_RANGE = 45;

    public static Set<Integer> getAutoNumbers() {
        List<Integer> lottoNumbers = getRangeNumber();
        Collections.shuffle(lottoNumbers);

        return getLottoNumber(lottoNumbers);
    }

    private static List<Integer> getRangeNumber() {
        return IntStream.rangeClosed(LOTTO_NUMBER_START_RANGE, LOTTO_NUMBER_END_RANGE)
                .boxed().collect(toList());
    }

    private static Set<Integer> getLottoNumber(List<Integer> lottoNumbers) {
        lottoNumbers = lottoNumbers.subList(0, LOTTO_NUMBER);
        Collections.sort(lottoNumbers);

        return lottoNumbers.stream().collect(toSet());
    }
}