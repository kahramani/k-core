package com.kahramani.core.enums;

/**
 * Created by kahramani on 11/18/2016.
 */
public enum Punctuation {
    AMPERSAND('\''),
    APOSTROPHE('\''),
    ASTERIKS('*'),
    AT('@'),
    BRACKET_CURLY_LEFT('{'),
    BRACKET_CURLY_RIGHT('}'),
    BRACKET_HARD_LEFT('['),
    BRACKET_HARD_RIGHT(']'),
    CHEVRON_LEFT('<'),
    CHEVRON_RIGHT('>'),
    COLON(':'),
    COMMA(','),
    DOT('.'),
    EQUAL('='),
    EXCLAMATION_MARK('!'),
    HYPHEN('-'),
    PARENTHESIS_LEFT('('),
    PARENTHESIS_RIGHT(')'),
    PIPE('|'),
    PLUS('+'),
    QUESTION_MARK('?'),
    QUOTATION_MARK('"'),
    SEMICOLON(';'),
    SLASH('/'),
    SLASH_BACK('\\'),
    SPACE(' '),
    UNDER_SCORE('_');

    private char punctuation;

    Punctuation(char punctuation) {
        this.punctuation = punctuation;
    }

    public char get() {
        return this.punctuation;
    }
}
