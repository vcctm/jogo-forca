package interclasses.utils;

import java.util.Arrays;
import java.util.List;

public class GFG {
  public static List<Character> removeDuplicate(char str[], int n)
  {
    // Used as index in the modified string
    int index = 0;

    // Traverse through all characters
    for (int i = 0; i < n; i++)
    {

      // Check if str[i] is present before it
      int j;
      for (j = 0; j < i; j++)
      {
        if (str[i] == str[j])
        {
          break;
        }
      }

      // If not present, then add it to
      // result.
      if (j == i)
      {
        str[index++] = str[i];
      }
    }
    String noDuplicates = String.valueOf(Arrays.copyOf(str, index));
    List<Character> listWordLetters = Arrays.asList(new Character[noDuplicates.length()]);
    for (int i = 0; i < noDuplicates.length(); i++) {
      char letter = noDuplicates.charAt(i);
      if(!listWordLetters.contains(letter)) {
        listWordLetters.set(i, letter);
      }
    }
    return listWordLetters;
  }
}
