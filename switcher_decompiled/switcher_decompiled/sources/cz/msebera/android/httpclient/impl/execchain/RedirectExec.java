package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes2.dex */
public class RedirectExec implements ClientExecChain {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final RedirectStrategy redirectStrategy;
    private final ClientExecChain requestExecutor;
    private final HttpRoutePlanner routePlanner;

    public RedirectExec(ClientExecChain clientExecChain, HttpRoutePlanner httpRoutePlanner, RedirectStrategy redirectStrategy) {
        Args.notNull(clientExecChain, "HTTP client request executor");
        Args.notNull(httpRoutePlanner, "HTTP route planner");
        Args.notNull(redirectStrategy, "HTTP redirect strategy");
        this.requestExecutor = clientExecChain;
        this.routePlanner = httpRoutePlanner;
        this.redirectStrategy = redirectStrategy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0122, code lost:
    
        return r4;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [cz.msebera.android.httpclient.client.methods.HttpRequestWrapper] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r4v0, types: [cz.msebera.android.httpclient.impl.execchain.ClientExecChain] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public cz.msebera.android.httpclient.client.methods.CloseableHttpResponse execute(cz.msebera.android.httpclient.conn.routing.HttpRoute r10, cz.msebera.android.httpclient.client.methods.HttpRequestWrapper r11, cz.msebera.android.httpclient.client.protocol.HttpClientContext r12, cz.msebera.android.httpclient.client.methods.HttpExecutionAware r13) throws java.io.IOException, cz.msebera.android.httpclient.HttpException {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.msebera.android.httpclient.impl.execchain.RedirectExec.execute(cz.msebera.android.httpclient.conn.routing.HttpRoute, cz.msebera.android.httpclient.client.methods.HttpRequestWrapper, cz.msebera.android.httpclient.client.protocol.HttpClientContext, cz.msebera.android.httpclient.client.methods.HttpExecutionAware):cz.msebera.android.httpclient.client.methods.CloseableHttpResponse");
    }
}
