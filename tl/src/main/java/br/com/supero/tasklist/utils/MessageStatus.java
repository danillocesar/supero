package br.com.supero.tasklist.utils;

public enum MessageStatus {
	CADASTRO_SUCESSO("Cadastro efetuado com sucesso.", 100), 
	ERRO_INTERNO("Ocorreu um erro interno. Por favor tente novamente.", 300),
	LOGIN_INVALIDO("Login ou senha inválidos.", 500);
	
	private String descricao;
	public int status;
	MessageStatus(String descricao, int status) {
        this.descricao = descricao;
        this.status = status;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

    public static MessageStatus getByStatus(int status){
    	 for(MessageStatus e : MessageStatus.values()){
		    if(status == e.status) return e;
		  }
    	 return null;
    }
}
