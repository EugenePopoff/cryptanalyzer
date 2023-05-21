package com.javarush.cryptanalyzer.popov.constants;

public class TextConstants {
    public static final String ENTER_KEY_PROMPT = "Enter encryption key (or press Enter to generate a random key): ";
    public static final String RANDOM_KEY_MSG = "Random key generated: ";
    public static final String INVALID_KEY_MSG = "Invalid encryption/decryption key. Please enter a numeric value.";
    public static final String INPUT_FILE_DEFAULT = "input.txt";
    public static final String ENCODED_FILE_DEFAULT = "encoded.txt";
    public static final String INPUT_FILE_PROMPT_FORMAT = "Enter input file name (or press Enter to use the default file \"%s\"): ";
    public static final String INVALID_FILE_PROMPT_FORMAT = "File \"%s\" does not exist or is a directory. Please enter a valid input file name.";
    public static final String ENTER_OPERATION_TYPE = """
            Enter operation type:
            Encrypt (press 1)
            Decrypt (press 2)
            Brute Force (press 3)
            """;
    public static final String INVALID_OPERATION_TYPE = "Invalid operation type. Please enter 'encrypt' or 'decrypt' (or '1' or '2' or '3').";
    public static final String DEFAULT_OUTPUT_FILE_ENCRYPTED = "encoded.txt";
    public static final String DEFAULT_OUTPUT_FILE_DECRYPTED = "output.txt";
    public static final String OUTPUT_FILE_PROMPT = "Enter output file name (or press Enter to use the default file \"%s\"): ";
    public static final String ERROR_WRITING = "Ошибка при записи в файл: ";
    public static final String MESSAGE_CANNOT_BE_NULL = "Message cannot be null";
    public static final String CONTINUE_MESSAGE = "Do you want to continue?\nTo continue, press \"y\" , to exit the program, press any button: ";
    public static final String ENTER_KEY_DECRYPT = "Enter decryption key: ";
    public static final String CRACKED_MESSAGE = "\nThe key is cracked...";
}