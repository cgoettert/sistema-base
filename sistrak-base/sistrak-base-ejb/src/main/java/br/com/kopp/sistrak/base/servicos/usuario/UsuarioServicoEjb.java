package br.com.kopp.sistrak.base.servicos.usuario;

import br.com.kopp.framework.datatables.RequestData;
import br.com.kopp.framework.datatables.ResponseData;
import br.com.kopp.framework.message.code.KoppCode;
import br.com.kopp.framework.ejb.KoppEJB;
import br.com.kopp.sistrak.base.comum.exception.SkepyException;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cgoettert
 */
@Stateless
public class UsuarioServicoEjb extends KoppEJB implements UsuarioServicoLocal {

    @Inject
    private UsuarioDao usuarioDao;

    @Override
    public ResponseData montarTabela(RequestData requestData) throws SkepyException {

        ResponseData responseData = usuarioDao.mountTable(requestData);

        responseData.setData(getMapper()
                .comFunction(UsuarioConversor.obterConversorUsuarioParaUsuarioDTO())
                .converterLista(responseData.getData()));

        return responseData;
    }

    @Override
    public UsuarioDto get(Integer id) throws SkepyException {
        int minVal = 0;

        if (id < minVal) {
            throw new SkepyException(KoppCode.VALOR_MENOR_QUE_MINIMO, minVal, id);
        }

        Usuario usuario = usuarioDao.find(id);

        if (usuario == null) {
            throw new SkepyException(KoppCode.VALOR_NULO);
        }

        return getMapper()
                .comFunction(UsuarioConversor.obterConversorUsuarioParaUsuarioDTO())
                .converterObjeto(usuario);
    }

}
