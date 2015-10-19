
layout 'layouts/main.tpl',
        pageTitle: 'List persons',
        mainBody: contents {
            ul {
                div ("aaaa $pings2")
//                pings.each { ping ->
//                    li {
//                        a(href:"/person/$ping.id", "$ping.hour $ping.minute")
//                    }
//                }
            }

            div {
                a(href:'/person/add', 'Add new person')
            }
        }
