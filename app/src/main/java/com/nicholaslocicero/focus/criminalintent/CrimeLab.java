package com.nicholaslocicero.focus.criminalintent;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CrimeLab {

  private static CrimeLab sCrimeLab;

  private List<Crime> mCrimes;
  private Map<UUID, Crime> mCrimesById;


  public static CrimeLab get(Context context) {
    if (sCrimeLab == null) {
      sCrimeLab = new CrimeLab(context);
    }
    return sCrimeLab;
  }

  private CrimeLab(Context context) {
    mCrimes = new ArrayList<>();
    mCrimesById = new HashMap<>();
    for (int i = 0; i < 100; i++) {
      Crime crime = new Crime();
      crime.setTitle("Crime #" + i);
      crime.setSolved(i % 2 == 0);
      mCrimes.add(crime);
      mCrimesById.put(crime.getId(), crime);
    }
  }

  public Crime getCrime(UUID id) {
    if (mCrimesById.containsKey(id)) {
      return mCrimesById.get(id);
    }
    return null;
  }

  public int getCrimePosition(UUID id) {
    int count = 0;
    for (Crime crime : mCrimes) {
      if (crime.getId().equals(id)) {
        return count;
      }
      count++;
    }
    return 0;
  }

  public List<Crime> getCrimes() {
    return mCrimes;
  }

}
