var InitiateSimpleDataTable = function() {
    return {
        init: function() {
            //Datatable Initiating
            var oTable = $('#simpledatatable').dataTable({
                "sDom": "Tflt<'row DTTTFooter'<'col-sm-6'i><'col-sm-6'p>>",
                "iDisplayLength": 5,
                "oTableTools": {
                    "aButtons": [
                        "copy", "csv", "xls", "pdf"
                    ],
                },
                "language": {
                    "search": "",
                    "sLengthMenu": "_MENU_",
                    "oPaginate": {
                        "sPrevious": "Prev",
                        "sNext": "Next"
                    }
                },
                "aoColumns": [
                    null,
                    { "bSortable": false },
                    null,
                    { "bSortable": false }
                ],
                
                "aaSorting": []
            });

        }

    };

}();