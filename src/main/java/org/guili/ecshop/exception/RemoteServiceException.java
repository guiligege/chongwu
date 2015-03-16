package org.guili.ecshop.exception;

/**
 * 由于远程的第三方服务的原因抛出的异常,例如远程服务返回的
 *
 * User: walter
 * Date: 5/5/14
 * Time: 4:17 PM
 */
public class RemoteServiceException extends RuntimeException {

    public RemoteServiceException() {
        super();
    }

    public RemoteServiceException(String message) {
        super(message);
    }

    public static class EmptyResponseContent extends RemoteServiceException{

        public EmptyResponseContent() {
            super();
        }

        public EmptyResponseContent(String message) {
            super(message);
        }
    }
}