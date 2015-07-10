/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel.cards;

/**
 *
 * @author JotaSe
 */
public class Card {

    private final value _value;
    private final type _type;

    public Card(value _value, type _type) {
        this._value = _value;
        this._type = _type;
    }

    public value getValue() {
        return _value;
    }

    public type getType() {
        return _type;
    }

    public enum value {

        A_CARD(1),
        TWO_CARD(2),
        THREE_CARD(3),
        FOUR_CARD(4),
        FIVE_CARD(5),
        SIX_CARD(6),
        SEVEN_CARD(7),
        EIGHT_CARD(8),
        NINE_CARD(9),
        TEN_CARD(10),
        J_CARD(11),
        Q_CARD(12),
        K_CARD(12);
        public final int _value;

        value(int val) {
            this._value = val;
        }
    }

    public enum type {

        HEARTs(1),
        DIAMONDs(2),
        CLUBS(3),
        SPADES(4);
        public final int _value;

        type(int val) {
            this._value = val;
        }
    }
}
