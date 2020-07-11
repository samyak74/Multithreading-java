package miscTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

	private static String prependWithLpn(String existingLai, String lpn) {
		String resultString = "";
		resultString = resultString.concat(lpn + ", ");
		resultString = resultString.concat(existingLai);
		return resultString;

	}

	public static void main(String[] args) {
		Map<String, List<String>> localeAdditionalInfo = new HashMap<>();
		localeAdditionalInfo.put("vi", Arrays.asList("Senayan Plaza vi, Senayan City Hall"));
		localeAdditionalInfo.put("th", Arrays.asList("Senayan Plaza th, Senayan City Hall"));
		localeAdditionalInfo.put("ms", Arrays.asList("Senayan Plaza ms, Senayan City Hall"));
		localeAdditionalInfo.put("id", Arrays.asList("Senayan Plaza id, Senayan City Hall"));
		Map<String, String> localeProductNames = new HashMap<>();
		localeProductNames.put("vi", "TEST vi");
		localeProductNames.put("th", "TEST th");
		localeProductNames.put("en", "TEST en");
		localeProductNames.put("id", "TEST id");
		for (Map.Entry<String, List<String>> entry : localeAdditionalInfo.entrySet()) {
			if (localeProductNames.get(entry.getKey()) != null) {
				String existingLai;
				if (entry.getValue() != null && entry.getValue().get(0) != null) {
					existingLai = entry.getValue().get(0);
				} else {
					continue;
				}
				existingLai = prependWithLpn(existingLai, localeProductNames.get(entry.getKey()));
				localeAdditionalInfo.put(entry.getKey(), Arrays.asList(existingLai));
			}
		}

		System.out.println(localeAdditionalInfo);


	}
}
