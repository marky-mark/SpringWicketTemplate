package com.mycompany;


import com.mycompany.view.HomePage;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.pages.InternalErrorPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IExceptionSettings;
import org.apache.wicket.settings.IResourceSettings;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class WicketApplication extends WebApplication
{    
    @Override
    protected void init() {
        super.init();

        //getComponentInstantiationListeners().add(new SpringComponentInjector(this));

        IResourceSettings resourceSettings = getResourceSettings();
        resourceSettings.addResourceFolder("WEB-INF/html");

        getApplicationSettings().setPageExpiredErrorPage(InternalErrorPage.class);
        getApplicationSettings().setInternalErrorPage(InternalErrorPage.class);
        getExceptionSettings().setUnexpectedExceptionDisplay(IExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);

        mountPage("/test", HomePage.class);
    }
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<? extends Page> getHomePage()
	{
		return HomePage.class;
	}

}
