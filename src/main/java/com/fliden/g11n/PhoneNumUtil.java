package com.fliden.g11n;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class PhoneNumUtil {

    static boolean isValid(String number) {
        final Phonenumber.PhoneNumber parsedNumber = parsePhoneNumber(number, "US");
        if (parsedNumber == null) {
            return false;
        } else {
            return PhoneNumberUtil.getInstance().isValidNumber(parsedNumber);
        }
    }

    static String getFormatted(String number, String format) {
        final PhoneNumberUtil.PhoneNumberFormat parsedFormat = PhoneNumberUtil.PhoneNumberFormat.valueOf(format);
        final Phonenumber.PhoneNumber parsedNumber = parsePhoneNumber(number, "US");
        if (parsedNumber == null) {
            return null;
        } else {
            return PhoneNumberUtil.getInstance().format(parsedNumber, parsedFormat);
        }
    }

    private static Phonenumber.PhoneNumber parsePhoneNumber(final String num, final String region) {
        final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            final Phonenumber.PhoneNumber phoneNumber = phoneUtil.parse(num, region);
            return phoneNumber;
        } catch (NumberParseException e) {
            return null;
        }
    }
}
