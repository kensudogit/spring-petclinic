package org.springframework.samples.petclinic.system;

// このクラスは、サンプルの例外を表します。
// RuntimeExceptionを継承しています。
public class ShowcaseException extends RuntimeException {
    // コンストラクタは、例外メッセージを受け取ります。
    public ShowcaseException(String message) {
        super(message);
    }
}